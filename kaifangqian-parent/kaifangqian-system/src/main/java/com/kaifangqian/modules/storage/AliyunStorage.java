/**
 * @Discription:文件存储BASE64接口类
 */
package com.kaifangqian.modules.storage;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import com.kaifangqian.modules.storage.config.StorageProperties;
import com.kaifangqian.exception.PaasException;
import com.kaifangqian.utils.MyStringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 阿里云对象存储服务
 */
@Slf4j
@Service
@ConditionalOnProperty(prefix = "paas.storage", name = "active", havingValue = "aliyun")
public class AliyunStorage implements Storage {

    @Autowired
    private StorageProperties properties;
//    private String endpoint;
//    private String accessKeyId;
//    private String accessKeySecret;
//    private String bucketName;
//    private String publicEndpoint;

    /**
     * 获取阿里云OSS客户端对象
     *
     * @return ossClient
     */
    @Override
    public OSS getOSSClient() {
        return new OSSClientBuilder().build(properties.getAliyun().getEndpoint(), properties.getAliyun().getAccessKeyId(), properties.getAliyun().getAccessKeySecret());
    }

    private String getBaseUrl() {
        return "https://" + properties.getAliyun().getBucketName() + "." + properties.getAliyun().getEndpoint() + "/";
    }

    private String getPublicBaseUrl() {
        return "https://" + properties.getAliyun().getBucketName() + "." + properties.getAliyun().getPublicendpoint() + "/";
    }

    /**
     * 阿里云OSS对象存储简单上传实现
     */
    @Override
    public boolean store(InputStream inputStream, long contentLength, String contentType, String keyName) {
        OSS ossClient = null;
        try {
            // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20M以下的文件使用该接口
            PutObjectRequest putObjectRequest = null;
            if (MyStringUtils.isNotBlank(contentType)) {
                ObjectMetadata objectMetadata = new ObjectMetadata();
                objectMetadata.setContentLength(contentLength);
                objectMetadata.setContentType(contentType);
                // 对象键（Key）是对象在存储桶中的唯一标识。
                putObjectRequest = new PutObjectRequest(properties.getAliyun().getBucketName(), keyName, inputStream, objectMetadata);
            } else {
                putObjectRequest = new PutObjectRequest(properties.getAliyun().getBucketName(), keyName, inputStream);
            }
            ossClient = getOSSClient();
            PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
            if (putObjectResult != null) {
                return true;
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        } finally {
            if (ossClient != null) {
                try {
                    ossClient.shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return false;
    }

    @Override
    public Resource loadAsResource(String keyName) {
        try {
            URL url = new URL(getBaseUrl() + keyName);
            Resource resource = new UrlResource(url);
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public InputStream loadAsInputStream(String keyName, OSS client) {
        try {
            OSSObject ossObject = client.getObject(properties.getAliyun().getBucketName(), keyName);
            return ossObject.getObjectContent();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new PaasException("文件不存在");
        }
    }

    @Override
    public void delete(String keyName) {
        OSS ossClient = null;
        try {
            ossClient = getOSSClient();
            ossClient.deleteObject(properties.getAliyun().getBucketName(), keyName);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            if (ossClient != null) {
                try {
                    ossClient.shutdown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String generateUrl(String keyName) {
        return getPublicBaseUrl() + keyName;
    }
}
