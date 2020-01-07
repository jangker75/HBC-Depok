package com.hbc.depok.model

import com.google.gson.annotations.SerializedName

class Member{
        @SerializedName("api_authorization")
        val apiAuthorization:String? = null
        @SerializedName("api_http")
        val apiHttp: Int? =null
        @SerializedName("api_message")
        val apiMessage: String? =null
        @SerializedName("api_status")
        val apiStatus: Int? =null
        @SerializedName("data")
      lateinit var data: List<DataMember>
}