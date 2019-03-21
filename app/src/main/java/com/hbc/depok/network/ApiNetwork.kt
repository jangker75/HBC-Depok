package com.hbc.depok.network

import com.hbc.depok.model.LoginModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiNetwork {
    @GET("artikel")
    fun getArtikel(): Observable<ApiResponse>

    @GET("list_member")
    fun getData(): Observable<ApiResponse>

    @GET("login?")
    fun getLogin(@Query("kode_anggota") kode_anggota: String, @Query("password") password: String): Call<LoginModel>
}