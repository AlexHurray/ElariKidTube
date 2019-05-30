package com.mks.elarikidtube.api;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApi {
    private static final String URL = "https://www.googleapis.com/";
    private static final String API_KEY = "AIzaSyAUK3FqjZyTQljbp_yLZLoddf0xonQco9s";
    private static final int TIMEOUT_IN_SECONDS = 2;

    private static YoutubeEndpoint youtubeEndpoint;

    public static synchronized YoutubeEndpoint youtube() {
        if (youtubeEndpoint == null) {
            youtubeEndpoint = createNewsEndpoint();
        }
        return youtubeEndpoint;
    }

    private RestApi() {
        throw new AssertionError("No instances");
    }

    @NonNull
    private static Retrofit buildRetrofitClient(@NonNull OkHttpClient client) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();


        return new Retrofit.Builder()
                .baseUrl(URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @NonNull
    private static OkHttpClient buildOkHttpClient() {

        return new OkHttpClient.Builder()
                .addInterceptor(ApiKeyInterceptor.create(API_KEY))
                .connectTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                .writeTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)
                .build();
    }

    @NonNull
    private static YoutubeEndpoint createNewsEndpoint() {
        final OkHttpClient httpClient = buildOkHttpClient();
        final Retrofit retrofit = buildRetrofitClient(httpClient);

        return retrofit.create(YoutubeEndpoint.class);
    }
}
