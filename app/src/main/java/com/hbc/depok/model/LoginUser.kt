package com.hbc.depok.model


import com.google.gson.annotations.SerializedName

data class LoginUser(
    @SerializedName("api_message")
    val apiMessage: String?,
    @SerializedName("api_status")
    val apiStatus: Int?,
    @SerializedName("foto1")
    val foto1: String?,
    @SerializedName("foto2")
    val foto2: String?,
    @SerializedName("foto3")
    val foto3: Any?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("kode_anggota")
    val kodeAnggota: String?,
    @SerializedName("Nama")
    val nama: String?,
    @SerializedName("No_plat")
    val noPlat: String?
)