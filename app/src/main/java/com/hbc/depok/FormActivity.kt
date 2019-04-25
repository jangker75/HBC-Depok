package com.hbc.depok

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.hbc.depok.api.masterAPI
import com.hbc.depok.model.ArticleModel
import com.hbc.depok.model.GantiPassModel
import com.hbc.depok.model.SoalModel
import com.hbc.depok.network.ApiNetwork
import com.hbc.depok.network.ApiResponseSoal
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.content_change_password.*
import retrofit2.Call
import retrofit2.Response

class FormActivity : AppCompatActivity() {
    private val dataSoal: MutableList<SoalModel> = mutableListOf()
    val retrofit = masterAPI.getRetrofit.create(ApiNetwork::class.java)
//    val sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE)
//    val IDLogin = sharedPreferences.getString("kd_anggota", "kd_anggota")
//    val NamaLogin = sharedPreferences.getString("nama", "nama")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        retrofit.getSoal()
                .enqueue(object : retrofit2.Callback<ApiResponseSoal> {
                    override fun onFailure(call: Call<ApiResponseSoal>, t: Throwable) {
                        Log.d("gagal", "Server Error")

                    }

                    override fun onResponse(call: Call<ApiResponseSoal>, response: Response<ApiResponseSoal>) {

                        val data = response?.body()
                        val msg = data?.api_message
                        if (msg == "success") {
                            setData(data.data)
                            val countData = dataSoal.count()
                            for (i in 0 until (countData)) {
                                if (i == 0) {
                                    if (dataSoal[i].soal != null) {
                                        kolomQ1.visibility = View.VISIBLE
                                        if (dataSoal[i].tipe == "Radio") {
                                            input_text_Q1.visibility = View.GONE
                                            radioGroupQ1.visibility = View.VISIBLE
                                            txtQ1.setText(dataSoal[i].soal)
                                            radio1Q1.setText(dataSoal[i].jawaban1)
                                            radio2Q1.setText(dataSoal[i].jawaban2)
                                            radio3Q1.setText(dataSoal[i].jawaban3)
                                        } else {
                                            input_text_Q1.visibility = View.VISIBLE
                                            radioGroupQ1.visibility = View.GONE
                                            txtQ1.setText(dataSoal[i].soal)
                                        }
                                    }
                                } else if (i == 1) {
                                    if (dataSoal[i].soal != null) {
                                        kolomQ2.visibility = View.VISIBLE
                                        if (dataSoal[i].tipe == "Radio") {
                                            input_text_Q2.visibility = View.GONE
                                            radioGroupQ2.visibility = View.VISIBLE
                                            txtQ2.setText(dataSoal[i].soal)
                                            radio1Q2.setText(dataSoal[i].jawaban1)
                                            radio2Q2.setText(dataSoal[i].jawaban2)
                                            radio3Q2.setText(dataSoal[i].jawaban3)
                                        } else {
                                            input_text_Q2.visibility = View.VISIBLE
                                            radioGroupQ2.visibility = View.GONE
                                            txtQ2.setText(dataSoal[i].soal)
                                        }
                                    }
                                } else if (i == 2) {
                                    if (dataSoal[i].soal != null) {
                                        kolomQ3.visibility = View.VISIBLE
                                        if (dataSoal[i].tipe == "Radio") {
                                            input_text_Q3.visibility = View.GONE
                                            radioGroupQ3.visibility = View.VISIBLE
                                            txtQ3.setText(dataSoal[i].soal)
                                            radio1Q3.setText(dataSoal[i].jawaban1)
                                            radio2Q3.setText(dataSoal[i].jawaban2)
                                            radio3Q3.setText(dataSoal[i].jawaban3)
                                        } else {
                                            input_text_Q3.visibility = View.VISIBLE
                                            radioGroupQ3.visibility = View.GONE
                                            txtQ3.setText(dataSoal[i].soal)
                                        }
                                    }
                                } else if (i == 3) {
                                    if (dataSoal[i].soal != null) {
                                        kolomQ4.visibility = View.VISIBLE
                                        if (dataSoal[i].tipe == "Radio") {
                                            input_text_Q4.visibility = View.GONE
                                            radioGroupQ4.visibility = View.VISIBLE
                                            txtQ4.setText(dataSoal[i].soal)
                                            radio1Q4.setText(dataSoal[i].jawaban1)
                                            radio2Q4.setText(dataSoal[i].jawaban2)
                                            radio3Q4.setText(dataSoal[i].jawaban3)
                                        } else {
                                            input_text_Q4.visibility = View.VISIBLE
                                            radioGroupQ4.visibility = View.GONE
                                            txtQ4.setText(dataSoal[i].soal)
                                        }
                                    }
                                }
                            }
                        } else {
//                                 Toast.makeText(this@ChangePasswordActivity, msg, Toast.LENGTH_SHORT).show()
                            basicAlert(msg, "Maaf data error")

                        }
                    }
                })

    }

    fun setData(datas: List<SoalModel>) {
        dataSoal.addAll(datas)
    }

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
                android.R.string.yes, Toast.LENGTH_SHORT).show()
    }

    fun basicAlert(msg: String?, nama: String?) {

        val builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Message")
            setMessage("$nama, $msg")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
            show()
        }
    }
}
