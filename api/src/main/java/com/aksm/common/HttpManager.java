

package com.aksm.common;

/**
 * HttpManager.
 *
 * @author ashwani
 * @since 2016-05-05
 */

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

public class HttpManager {
    private static HttpManager instance = new HttpManager();
    private OkHttpClient okHttpClient;
    private static final int TIME_OUT = 60;

    private HttpManager() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.connectTimeout(TIME_OUT, TimeUnit.SECONDS);
        httpClient.readTimeout(TIME_OUT, TimeUnit.SECONDS);
        httpClient.writeTimeout(TIME_OUT, TimeUnit.SECONDS);
        httpClient.retryOnConnectionFailure(false);
        okHttpClient = httpClient.build();
    }

    public static HttpManager getInstance() {
        return instance;
    }


    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }


}

