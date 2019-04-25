package com.hbc.depok.network

import com.hbc.depok.model.GantiPassModel
import com.hbc.depok.model.LoginModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiNetwork {
    @GET("article")
    fun getArtikel(): Observable<ApiResponseArticle>

    @GET("list_member")
    fun getData(): Observable<ApiResponseMember>

    @GET("list_soal")
    fun getSoal(): Call<ApiResponseSoal>

    @GET("login?")
    fun getLogin(@Query("kode_anggota") kode_anggota: String, @Query("password") password: String): Call<LoginModel>

    @GET("ganti_pass?")
    fun getGantiPass(@Query("kd_anggota") kode_anggota: String, @Query("old_pass") old_pass: String, @Query("new_pass") new_pass: String): Call<GantiPassModel>
}