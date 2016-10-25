package com.example.kenguyen.codernews.Utils;

import com.example.kenguyen.codernews.BuildConfig;
import com.example.kenguyen.codernews.api.ApiResponse;
import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.apiKey;
import static com.example.kenguyen.codernews.Utils.Constant.BASE_URL;

/**
 * Created by KeNguyen on 25/10/2016.
 */

public class RetrofitUtils {
    public static final okhttp3.MediaType JSON = okhttp3.MediaType.parse("application/json; charset=utf-8");
    public static final Gson GSON = new Gson();

    public static Retrofit get(String apiKey){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client(apiKey))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private static OkHttpClient client(String apiKey){
        return new OkHttpClient.Builder()
                .addInterceptor(apiKeyInterCeptor(apiKey) )
                .addInterceptor(responseInterceptor())
                .build();
    }

    private static Interceptor responseInterceptor(){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response =chain.proceed(request);
                ResponseBody responseBody = response.body();
                ApiResponse apiResponse = GSON.fromJson(responseBody.string(),ApiResponse.class);
                responseBody.close();
                response = response.newBuilder()
                        .body(ResponseBody.create(JSON,apiResponse.getResponse().toString()))
                        .build();
                return response;
            }
        };
    }


    private static Interceptor apiKeyInterCeptor(final String apiKey){
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                HttpUrl url = request.url()
                        .newBuilder()
                        .addQueryParameter("api_key",apiKey)
                        .build();
                request = request.newBuilder()
                        .url(url)
                        .build();
                return chain.proceed(request);
            }
        };
    }
}
