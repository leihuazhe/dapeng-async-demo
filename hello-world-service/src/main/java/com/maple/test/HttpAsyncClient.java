package com.maple.test;

import org.asynchttpclient.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author maple 2018.09.13 下午3:48
 */
public class HttpAsyncClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(HttpAsyncClient.class);
    /**
     * 设置等待数据超时时间5秒钟 根据业务调整
     */
    private static int socketTimeout = 5000;
    /**
     * 连接超时
     */
    private static int connectTimeout = 2000;
    /**
     * 连接池最大连接数
     */
    private static int poolSize = 3000;
    /**
     * 每个主机的并发最多只有1500，如果后端保有一台应用机就配置3000
     */
    private static int maxPerRoute = 1500;

    private static final ExecutorService executors = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public static ListenableFuture<Response> requestForGet(String url, String json) {
        AsyncHttpClient asyncHttpClient = Dsl.asyncHttpClient();
        ListenableFuture<Response> responseFuture = asyncHttpClient.prepareGet(url).execute();
        /*responseFuture.addListener(() -> {
            try {
                Response response = responseFuture.get();
                String responseBody = response.getResponseBody();
                future.complete(response.getResponseBody(Charset.forName("UTF-8")));
                LOGGER.info("返回结果: response: {}, body: {}", response, response.getResponseBody());
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.error(e.getMessage(), e);
                future.completeExceptionally(e);

            }
        }, executors);*/

        LOGGER.info("异步执行http over ");
        return responseFuture;
    }

    public static CompletableFuture<Response> requestForGet1(String url, String json) {
        AsyncHttpClient asyncHttpClient = Dsl.asyncHttpClient();


        CompletableFuture<Response> whenResponse = asyncHttpClient
                .prepareGet(url)
                .execute()
                .toCompletableFuture();

        /*responseFuture.addListener(() -> {
            try {
                Response response = responseFuture.get();
                String responseBody = response.getResponseBody();
                future.complete(response.getResponseBody(Charset.forName("UTF-8")));
                LOGGER.info("返回结果: response: {}, body: {}", response, response.getResponseBody());
            } catch (InterruptedException | ExecutionException e) {
                LOGGER.error(e.getMessage(), e);
                future.completeExceptionally(e);

            }
        }, executors);*/

        LOGGER.info("异步执行http over ");
        return whenResponse;
    }


}
