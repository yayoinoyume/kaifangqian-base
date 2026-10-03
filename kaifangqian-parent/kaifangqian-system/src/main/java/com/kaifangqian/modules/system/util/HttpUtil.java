package com.kaifangqian.modules.system.util;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Map;

/**
 * @author : zhenghuihan
 * create at:  2024/3/28  14:17
 * @description:
 */
public class HttpUtil {

    private static int connectTimeout = 3000; // 连接超时时间为 3 秒
    private static int readTimeout = 5000; // 读取超时时间为 5 秒

    public static String sendGet(String url, Map<String, String> headers, Map<String, String> params) throws IOException {
        StringBuilder urlBuilder = new StringBuilder(url);
        if (params != null && !params.isEmpty()) {
            urlBuilder.append("?");
            for (Map.Entry<String, String> entry : params.entrySet()) {
                urlBuilder.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }

        HttpURLConnection connection = (HttpURLConnection) new URL(urlBuilder.toString()).openConnection();
        connection.setRequestMethod("GET");
        setRequestHeaders(connection, headers);

        // 读取响应头部信息
        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return readResponse(connection.getInputStream());
        } else {
            return readResponse(connection.getErrorStream());
        }
    }


    private static String readResponse(java.io.InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        return response.toString();
    }

    public static String sendPost(String url, Map<String, String> headers, String requestBody) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        // 设置连接超时时间
        connection.setConnectTimeout(connectTimeout);
        // 设置读取超时时间
        connection.setReadTimeout(readTimeout);
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        setRequestHeaders(connection, headers);

        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(requestBody.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return readResponse(connection.getInputStream());
        } else {
            return readResponse(connection.getErrorStream());
        }
    }

    public static void disableSSLCertificateChecking() {
        Security.addProvider(new BouncyCastleProvider());
        TrustManager[] trustAllCertificates = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };

        try {
            SSLContext sc = SSLContext.getInstance("TLS");
            sc.init(null, trustAllCertificates, new SecureRandom());
            SSLSocketFactory socketFactory = sc.getSocketFactory();
            // Create SSLSocket with the desired cipher suite
            SSLSocket socket = (SSLSocket) socketFactory.createSocket("api.zyfudi.com", 5789);
            socket.setEnabledCipherSuites(new String[]{"ECDHE-RSA-CHACHA20-POLY1305"});

            socket.startHandshake();
            // Further code for your application logic

            HttpsURLConnection.setDefaultSSLSocketFactory(socketFactory);

            HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                public boolean verify(String hostname, SSLSession session) {
                    return true;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setCipher() {
        Security.addProvider(new BouncyCastleProvider());

        TrustManager[] trustAllCerts = new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {
                    }

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {
                    }
                }
        };

        SSLContext sc = null;
        try {
            sc = SSLContext.getInstance("TLS");
            //sc = SSLContext.getInstance("TLS", "BC");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            SSLSocketFactory socketFactory = sc.getSocketFactory();

            SSLSocket socket = (SSLSocket) socketFactory.createSocket("api.zyfudi.com", 5789);
            socket.setEnabledCipherSuites(new String[]{"TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384"});

            socket.startHandshake();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Further code for your application logic
    }

    private static void setRequestHeaders(HttpURLConnection connection, Map<String, String> headers) {
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                connection.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
    }
}
