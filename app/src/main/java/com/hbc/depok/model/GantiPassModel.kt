package com.hbc.depok.model

import com.google.gson.annotations.SerializedName

data class GantiPassModel(
                          @SerializedName("kd_anggota")
                      val kodeAnggota: String = "",
                          @SerializedName("nama_user")
                      val nama: String = "",
                          @SerializedName("api_message")
                      val apiMessage: String = "",
                          @SerializedName("api_status")
                      val apiStatus: Int = 0)