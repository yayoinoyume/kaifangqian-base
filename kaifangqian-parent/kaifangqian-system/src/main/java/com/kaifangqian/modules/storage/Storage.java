/**
 * @Discription:文件存储BASE64接口类
 */
package com.kaifangqian.modules.storage;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.net.URL;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 * 对象存储接口
 */
public interface Storage {

    /**
     * 存储一个文件对象
     *
     * @param inputStream   文件输入流
     * @param contentLength 文件长度
     * @param contentType   文件类型
     * @param keyName       文件名
     */
    boolean store(InputStream inputStream, long contentLength, String contentType, String keyName);

    void delete(String keyName);

    Resource loadAsResource(String keyName);

    InputStream loadAsInputStream(String keyName, OSS client);

    String generateUrl(String keyName);

    OSS getOSSClient();
}