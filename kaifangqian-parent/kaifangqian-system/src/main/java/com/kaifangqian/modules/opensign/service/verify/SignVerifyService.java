/**
 * @description 在线签名验签接口
 */
package com.kaifangqian.modules.opensign.service.verify;

import com.kaifangqian.common.vo.Result;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

/**
 * @Description: 在线签名验签接口
 * @Package: com.kaifangqian.modules.opensign.service.doc.impl
 * @ClassName: SignVerifyService
 * @author: Fusion
 * CreateTime:  2023/8/120  10:53
 * @copyright 本平台运营方
 */

public interface SignVerifyService {

    Result getImageFromPdf(MultipartFile file) throws IOException;
}
