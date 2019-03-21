package com.hbc.depok.model

import com.google.gson.annotations.SerializedName

data class LoginModel(@SerializedName("No_plat")
                      val noPlat: String = "",
                      @SerializedName("kode_anggota")
                      val kodeAnggota: String = "",
                      @SerializedName("Nama")
                      val nama: String = "",
                      @SerializedName("api_message")
                      val apiMessage: String = "",
                      @SerializedName("api_status")
                      val apiStatus: Int = 0,
                      @SerializedName("id")
                      val id: Int = 0,
                      @SerializedName("foto1")
                      val foto1: String? = null,
                      @SerializedName("foto3")
                      val foto2: String? = null,
                      @SerializedName("foto2")
                      val foto3: String? = null)