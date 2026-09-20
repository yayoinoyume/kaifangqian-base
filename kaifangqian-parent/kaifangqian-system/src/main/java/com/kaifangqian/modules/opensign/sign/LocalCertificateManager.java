package com.kaifangqian.modules.opensign.sign;

import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.BasicConstraints;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.asn1.x509.KeyUsage;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509ExtensionUtils;
import org.bouncycastle.cert.jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.jcajce.JcaContentSignerBuilder;

import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermissions;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

/**
 * 本地 CA 与签名证书管理器。
 *
 * 首次使用时生成一套自签名根 CA 和由该 CA 签发的签名证书，并持久化到数据目录。
 * 后续启动直接复用，保证历史签名可长期验证。私钥只写入本地数据卷，不进入代码仓库。
 */
public final class LocalCertificateManager {

    public static final String SIGNER_PFX_FILE = "kfq-local-signer.pfx";
    public static final String ROOT_CA_FILE = "kfq-local-ca.crt";
    public static final String SIGNER_ALIAS = "kfq-local-signer";

    private static final String KEY_ALGORITHM = "RSA";
    private static final int KEY_SIZE = 2048;
    private static final String SIGNATURE_ALGORITHM = "SHA256withRSA";
    private static final String ROOT_SUBJECT = "CN=Kaifangqian Local Root CA, O=Kaifangqian, C=CN";
    private static final String SIGNER_SUBJECT = "CN=Kaifangqian Local Signer, O=Kaifangqian, C=CN";

    private LocalCertificateManager() {
    }

    public static synchronized LocalCertificateMaterial loadOrCreate(String directory, String password) throws Exception {
        Path dir = Paths.get(directory);
        Path pfxPath = dir.resolve(SIGNER_PFX_FILE);
        Path rootPath = dir.resolve(ROOT_CA_FILE);

        if (Files.isRegularFile(pfxPath) && Files.isRegularFile(rootPath)
                && Files.size(pfxPath) > 0 && Files.size(rootPath) > 0) {
            return new LocalCertificateMaterial(Files.readAllBytes(pfxPath), Files.readAllBytes(rootPath));
        }

        Files.createDirectories(dir);
        LocalCertificateMaterial material = generate(password);
        Files.write(pfxPath, material.getPfxBytes());
        Files.write(rootPath, material.getRootCertificatePem());
        try {
            Files.setPosixFilePermissions(pfxPath, PosixFilePermissions.fromString("rw-------"));
        } catch (UnsupportedOperationException ignored) {
            // Windows 等不支持 POSIX 权限的文件系统直接跳过
        }
        return material;
    }

    private static LocalCertificateMaterial generate(String password) throws Exception {
        SecureRandom random = new SecureRandom();
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE, random);

        KeyPair rootKeyPair = keyPairGenerator.generateKeyPair();
        KeyPair signerKeyPair = keyPairGenerator.generateKeyPair();

        X500Name rootName = new X500Name(ROOT_SUBJECT);
        X500Name signerName = new X500Name(SIGNER_SUBJECT);

        Date notBefore = Date.from(Instant.now().minus(1, ChronoUnit.DAYS));
        Date rootNotAfter = Date.from(Instant.now().plus(3650, ChronoUnit.DAYS));
        Date signerNotAfter = Date.from(Instant.now().plus(1825, ChronoUnit.DAYS));

        JcaX509ExtensionUtils extensionUtils = new JcaX509ExtensionUtils();

        JcaX509v3CertificateBuilder rootBuilder = new JcaX509v3CertificateBuilder(
                rootName, randomSerial(random), notBefore, rootNotAfter, rootName, rootKeyPair.getPublic());
        rootBuilder.addExtension(Extension.basicConstraints, true, new BasicConstraints(true));
        rootBuilder.addExtension(Extension.keyUsage, true, new KeyUsage(KeyUsage.keyCertSign | KeyUsage.cRLSign));
        rootBuilder.addExtension(Extension.subjectKeyIdentifier, false,
                extensionUtils.createSubjectKeyIdentifier(rootKeyPair.getPublic()));
        ContentSigner rootContentSigner = new JcaContentSignerBuilder(SIGNATURE_ALGORITHM)
                .build(rootKeyPair.getPrivate());
        X509Certificate rootCertificate = new JcaX509CertificateConverter()
                .getCertificate(rootBuilder.build(rootContentSigner));
        rootCertificate.verify(rootKeyPair.getPublic());

        JcaX509v3CertificateBuilder signerBuilder = new JcaX509v3CertificateBuilder(
                rootName, randomSerial(random), notBefore, signerNotAfter, signerName, signerKeyPair.getPublic());
        signerBuilder.addExtension(Extension.basicConstraints, true, new BasicConstraints(false));
        signerBuilder.addExtension(Extension.keyUsage, true,
                new KeyUsage(KeyUsage.digitalSignature | KeyUsage.nonRepudiation));
        signerBuilder.addExtension(Extension.extendedKeyUsage, false,
                new ExtendedKeyUsage(KeyPurposeId.id_kp_emailProtection));
        signerBuilder.addExtension(Extension.subjectKeyIdentifier, false,
                extensionUtils.createSubjectKeyIdentifier(signerKeyPair.getPublic()));
        signerBuilder.addExtension(Extension.authorityKeyIdentifier, false,
                extensionUtils.createAuthorityKeyIdentifier(rootCertificate));
        ContentSigner signerContentSigner = new JcaContentSignerBuilder(SIGNATURE_ALGORITHM)
                .build(rootKeyPair.getPrivate());
        X509Certificate signerCertificate = new JcaX509CertificateConverter()
                .getCertificate(signerBuilder.build(signerContentSigner));
        signerCertificate.verify(rootKeyPair.getPublic());

        char[] passwordChars = password.toCharArray();
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null, null);
        keyStore.setKeyEntry(SIGNER_ALIAS, signerKeyPair.getPrivate(), passwordChars,
                new Certificate[]{signerCertificate, rootCertificate});
        ByteArrayOutputStream pfxOutput = new ByteArrayOutputStream();
        keyStore.store(pfxOutput, passwordChars);

        return new LocalCertificateMaterial(pfxOutput.toByteArray(), toPem(rootCertificate));
    }

    private static BigInteger randomSerial(SecureRandom random) {
        return new BigInteger(128, random).abs().add(BigInteger.ONE);
    }

    private static byte[] toPem(X509Certificate certificate) throws Exception {
        String base64 = Base64.getMimeEncoder(64, "\n".getBytes(StandardCharsets.US_ASCII))
                .encodeToString(certificate.getEncoded());
        String pem = "-----BEGIN CERTIFICATE-----\n" + base64 + "\n-----END CERTIFICATE-----\n";
        return pem.getBytes(StandardCharsets.US_ASCII);
    }

    public static final class LocalCertificateMaterial {
        private final byte[] pfxBytes;
        private final byte[] rootCertificatePem;

        public LocalCertificateMaterial(byte[] pfxBytes, byte[] rootCertificatePem) {
            this.pfxBytes = pfxBytes;
            this.rootCertificatePem = rootCertificatePem;
        }

        public byte[] getPfxBytes() {
            return pfxBytes;
        }

        public byte[] getRootCertificatePem() {
            return rootCertificatePem;
        }
    }
}
