package com.hbc.depok.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object masterAPI {
    private var retrofit: Retrofit?=null
    val getRetrofit: Retrofit
        get() {
            if(retrofit == null)
                retrofit = Retrofit.Builder()
                        .baseUrl("http://hbcdepok.com/data/public/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                        .build()
            return retrofit!!
        }
}