package com.kaifangqian.modules.opensign.sign;

import com.kaifangqian.pdfbox.RsaSignUtils;
import com.kaifangqian.pdfbox.ThirdPartyExternalSign;
import org.apache.pdfbox.util.Hex;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1Primitive;

import java.io.IOException;
import java.util.Base64;

/**
 * 本地证书签名器：使用本地 PKCS12 证书私钥生成 CMS/PKCS#7 签名，
 * 替代开放签原有的云盾远程签名调用。
 */
public class LocalExternalSign implements ThirdPartyExternalSign {

    private final RsaSignUtils rsaSignUtils;

    public LocalExternalSign(byte[] pfxBytes, String password) {
        this.rsaSignUtils = new RsaSignUtils(pfxBytes, password);
    }

    @Override
    public String sign(String sha256Hex) {
        try {
            return Base64.getEncoder().encodeToString(signDigest(Hex.decodeHex(sha256Hex)));
        } catch (IOException e) {
            throw new RuntimeException("本地签名失败", e);
        }
    }

    /**
     * 对原始 SHA-256 摘要生成 CMS/PKCS#7 签名（DER 编码）。
     */
    public byte[] signDigest(byte[] digest) throws IOException {
        byte[] cms = rsaSignUtils.sign(digest);
        try {
            // BouncyCastle 的 CMS getEncoded() 可能输出 BER 不定长编码，
            // 而 PDF /SubFilter=adbe.pkcs7.detached 要求 DER 编码。
            return ASN1Primitive.fromByteArray(cms).getEncoded(ASN1Encoding.DER);
        } catch (Exception e) {
            throw new IOException("CMS 转 DER 编码失败", e);
        }
    }
}
