package com.kaifangqian.modules.opensign.sign;

import com.kaifangqian.pdfbox.vo.AssinaturaPosition;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.PDSignature;
import org.apache.pdfbox.pdmodel.interactive.digitalsignature.SignatureOptions;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;
import java.util.List;

/**
 * 标准格式本地 PDF 签署器。
 *
 * 与 resrun-pdfbox 的 AssinaturaPDF2 不同，本类写入标准
 * /Filter=Adobe.PPKLite、/SubFilter=adbe.pkcs7.detached 标识，
 * 因此 pdfsig、Adobe Reader、PDFBox 等标准工具可以识别和验签。
 *
 * 签章图片作为页面内容写入，随后的 PKCS#7 分离签名覆盖整份增量更新，
 * 因此签章图片同样受到防篡改保护。
 */
public class LocalPdfSigner {

    private static final int DEFAULT_SIGNATURE_SIZE = 16384;

    private final LocalExternalSign externalSign;

    public LocalPdfSigner(byte[] pfxBytes, String password) {
        this.externalSign = new LocalExternalSign(pfxBytes, password);
    }

    public byte[] sign(byte[] pdfBytes,
                       byte[] defaultSealImage,
                       List<AssinaturaPosition> positions,
                       String name,
                       String location,
                       String reason) throws Exception {
        if (positions == null || positions.isEmpty()) {
            throw new IllegalArgumentException("签署位置不能为空");
        }

        try (PDDocument document = Loader.loadPDF(pdfBytes)) {
            int sealIndex = 0;
            for (AssinaturaPosition position : positions) {
                appendSealImage(document, position, defaultSealImage, sealIndex++);
            }

            PDSignature signature = new PDSignature();
            signature.setFilter(PDSignature.FILTER_ADOBE_PPKLITE);
            signature.setSubFilter(PDSignature.SUBFILTER_ADBE_PKCS7_DETACHED);
            signature.setName(name);
            signature.setLocation(location);
            signature.setReason(reason);
            signature.setSignDate(Calendar.getInstance());

            SignatureOptions options = new SignatureOptions();
            options.setPreferredSignatureSize(DEFAULT_SIGNATURE_SIZE);

            document.addSignature(signature, content -> externalSign.signDigest(sha256(content)), options);

            ByteArrayOutputStream output = new ByteArrayOutputStream();
            document.saveIncremental(output);
            return output.toByteArray();
        }
    }

    private void appendSealImage(PDDocument document,
                                 AssinaturaPosition position,
                                 byte[] defaultSealImage,
                                 int sealIndex) throws IOException {
        Integer pageNumber = position.getPage();
        if (pageNumber == null || pageNumber < 0 || pageNumber >= document.getNumberOfPages()) {
            throw new IllegalArgumentException("签署页码非法: " + pageNumber);
        }

        byte[] sealImage = position.getSeal();
        if (sealImage == null || sealImage.length == 0) {
            sealImage = defaultSealImage;
        }
        if (sealImage == null || sealImage.length == 0) {
            throw new IllegalArgumentException("签章图片为空");
        }

        PDPage page = document.getPage(pageNumber);
        PDImageXObject image = PDImageXObject.createFromByteArray(document, sealImage, "local-seal-" + sealIndex);

        float x = parseFloat(position.getOffsetX(), "offsetX");
        float y = parseFloat(position.getOffsetY(), "offsetY");
        float width = parseFloat(position.getSignWidth(), "signWidth");
        float height = parseFloat(position.getSignHeight(), "signHeight");

        try (PDPageContentStream contentStream = new PDPageContentStream(
                document, page, PDPageContentStream.AppendMode.APPEND, true, true)) {
            contentStream.drawImage(image, x, y, width, height);
        }
    }

    private static float parseFloat(String value, String fieldName) {
        try {
            return Float.parseFloat(value);
        } catch (Exception e) {
            throw new IllegalArgumentException("签署位置字段非法: " + fieldName + "=" + value, e);
        }
    }

    private static byte[] sha256(InputStream content) throws IOException {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] buffer = new byte[8192];
            int read;
            while ((read = content.read(buffer)) != -1) {
                digest.update(buffer, 0, read);
            }
            return digest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new IOException("SHA-256 算法不可用", e);
        }
    }
}
