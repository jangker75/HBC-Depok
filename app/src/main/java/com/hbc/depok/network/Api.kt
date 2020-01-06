package com.hbc.depok.network

import com.hbc.depok.model.Member
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET

interface Api {
        @GET("daftar_member")
        fun getDaftarMember(): Observable<Member>

}
