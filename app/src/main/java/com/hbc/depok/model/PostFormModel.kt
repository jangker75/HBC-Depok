package com.hbc.depok.model

import com.google.gson.annotations.SerializedName

data class PostFormModel(
        val apiMessage: String = "",
        @SerializedName("api_status")
        val apiStatus: Int = 0)