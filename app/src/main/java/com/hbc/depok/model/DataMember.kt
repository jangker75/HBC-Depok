package com.hbc.depok.model

import com.google.gson.annotations.SerializedName

data class DataMember(
        @SerializedName("Alamat")
        val alamat: Any?,
        @SerializedName("chapter_logo")
        val chapterLogo: String?,
        @SerializedName("chapter_nama")
        val chapterNama: String?,
        @SerializedName("foto1")
        val foto1: String?,
        @SerializedName("foto2")
        val foto2: Any?,
        @SerializedName("foto3")
        val foto3: Any?,
        @SerializedName("foto4")
        val foto4: String?,
        @SerializedName("foto5")
        val foto5: String?,
        @SerializedName("id")
        val id: String?,
        @SerializedName("id_chapter")
        val idChapter: String?,
        @SerializedName("id_regional")
        val idRegional: String?,
        @SerializedName("kode_anggota")
        val kodeAnggota: String?,
        @SerializedName("Nama")
        val nama: String?,
        @SerializedName("No_plat")
        val noPlat: String?,
        @SerializedName("No_Telp")
        val noTelp: String?,
        @SerializedName("regional_logo")
        val regionalLogo: String?,
        @SerializedName("regional_nama")
        val regionalNama: String?,
        @SerializedName("sosmed")
        val sosmed: String?

)