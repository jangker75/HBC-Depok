package com.hbc.depok.network

import com.hbc.depok.model.DataMember
import com.hbc.depok.model.LoginUser
import com.hbc.depok.model.Member
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("daftar_member")
    fun getDaftarMember(): Observable<Member>

    @GET("daftar_member")
    fun getDaftarMemberChapter(
            @Query("id_chapter") id_chapter: String): Observable<Member>

    @GET("auth/login")
    fun login(
            @Query("kode_anggota") id_anggota: String,
            @Query("password") password: String): Observable<LoginUser>
}
