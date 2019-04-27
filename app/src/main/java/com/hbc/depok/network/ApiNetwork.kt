package com.hbc.depok.network

import com.hbc.depok.model.GantiPassModel
import com.hbc.depok.model.LoginModel
import com.hbc.depok.model.PostFormModel
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

    @GET("tambah_form?")
    fun getTambahForm(@Query("kd_anggota") kd_anggota: String, @Query("nama") nama: String,
                      @Query("soal1") soal1: String?, @Query("jawaban1") jawaban1: String?,
                      @Query("soal2") soal2: String?, @Query("jawaban2") jawaban2: String?,
                      @Query("soal3") soal3: String?, @Query("jawaban3") jawaban3: String?,
                      @Query("soal4") soal4: String?, @Query("jawaban4") jawaban4: String?): Call<PostFormModel>
}