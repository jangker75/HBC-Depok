package com.hbc.depok.network

import com.hbc.depok.model.DataMember
import com.hbc.depok.model.Member
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {

    companion object {
        private val BASE_URL = "http://hbcdepok.com/data/public/api/"

        val api = getRetrofit().create(Api::class.java)

        fun getRetrofit(): Retrofit {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            return retrofit
        }
    }
}