package com.hbc.depok.network

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @author Filippo
 * @version 1.0.0
 * @since Sun, 08/04/2018 at 17:56.
 */

interface ApiNetwork {

    @GET("list_member")
    fun getData(): Observable<ApiResponse>
}