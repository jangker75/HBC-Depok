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
        fun create(): Api {
            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            val api = retrofit.create(Api::class.java)
            return api
        }
    }


//    private val api = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//            .build()
//    val retrofit = api.create(Api::class.java)

//    fun getMember(): List<Member>{
//        return api.getDaftarMember()
//    }
}