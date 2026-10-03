/**
 * @Discription:文件存储BASE64接口类
 */
package com.kaifangqian.modules.storage;

import com.aliyun.oss.OSS;
import com.kaifangqian.modules.storage.config.StorageProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * 服务器本地对象存储服务
 */
@Slf4j
@Service
@ConditionalOnProperty(prefix = "paas.storage", name = "active", havingValue = "local")
public class LocalStorage implements Storage {

    private String storagePath;
    private String address;

    private Path rootLocation;

    public LocalStorage(StorageProperties properties){
        this.storagePath = properties.getLocal().getStoragePath();
        this.rootLocation = Paths.get(storagePath);
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }



    @Override
    public boolean store(InputStream inputStream, long contentLength, String contentType, String keyName) {
        try {
            Path targetPath = rootLocation.resolve(keyName);
            if(!Files.exists(targetPath)){
                Files.createDirectories(targetPath);
            }
            Files.copy(inputStream, targetPath, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    private Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
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
    public InputStream loadAsInputStream(String keyName,OSS oss) {
        try {
            Path file = load(keyName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource.getInputStream();
            } else {
                return null;
            }
        } catch (MalformedURLException e) {
            log.error(e.getMessage(), e);
            return null;
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    @Override
    public void delete(String filename) {
        Path file = load(filename);
        try {
            Files.delete(file);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
    }

    @Override
    public String generateUrl(String keyName) {
        return address + keyName;
    }

    @Override
    public OSS getOSSClient() {
        return null;
    }
}
