package com.hbc.depok.network

import com.hbc.depok.model.LoginModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Filippo
 * @version 1.0.0
 * @since Sun, 08/04/2018 at 17:56.
 */

interface ApiNetwork {

    @GET("list_member")
    fun getData(): Observable<ApiResponse>

    @GET("cek_login?")
    fun getLogin(@Query("kode_anggota") kode_anggota: String, @Query("password") password: String): Call<LoginModel>
}