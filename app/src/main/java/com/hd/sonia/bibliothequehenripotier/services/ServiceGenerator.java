package com.hd.sonia.bibliothequehenripotier.services;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static okhttp3.OkHttpClient.*;

/**
 * Created by Sonia on 10/09/2016.
 */
public class ServiceGenerator {

    public static final String API_BASE_URL = "http://henri-potier.xebia.fr";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
