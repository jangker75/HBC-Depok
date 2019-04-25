package com.hbc.depok.network

import com.hbc.depok.model.SoalModel

class ApiResponseSoal {
    lateinit var api_message: String
    lateinit var data: List<SoalModel>
}