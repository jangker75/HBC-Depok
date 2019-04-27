package com.hbc.depok

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.hbc.depok.api.masterAPI
import com.hbc.depok.model.GantiPassModel
import com.hbc.depok.model.PostFormModel
import com.hbc.depok.model.SoalModel
import com.hbc.depok.network.ApiNetwork
import com.hbc.depok.network.ApiResponseSoal
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.content_change_password.*
import retrofit2.Call
import retrofit2.Response


class FormActivity : AppCompatActivity() {
    private val dataSoal: MutableList<SoalModel> = mutableListOf()
    val retrofit = masterAPI.getRetrofit.create(ApiNetwork::class.java)
    private var tipeQ1: String? = null
    private var tipeQ2: String? = null
    private var tipeQ3: String? = null
    private var tipeQ4: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        val sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE)
        val IDLogin = sharedPreferences.getString("kd_anggota", "kd_anggota")
        val NamaLogin = sharedPreferences.getString("nama", "nama")
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
                                    tipeQ1 = dataSoal[i].tipe
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
                                    tipeQ2 = dataSoal[i].tipe
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
                                    tipeQ3 = dataSoal[i].tipe
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
                                    tipeQ4 = dataSoal[i].tipe
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

        btnSubmitFormResign.setOnClickListener {
            val Q1 = txtQ1.text?.toString()
            val Q2 = txtQ2.text?.toString()
            val Q3 = txtQ3.text?.toString()
            val Q4 = txtQ4.text?.toString()
            var Answer1: String? = null
            var Answer2: String? = null
            var Answer3: String? = null
            var Answer4: String? = null
            val AT1 = input_text_Q1.text.toString()
            val AT2 = input_text_Q2.text.toString()
            val AT3 = input_text_Q3.text.toString()
            val AT4 = input_text_Q4.text.toString()

            val AR1 = getRadio(radioGroupQ1)
            val AR2 = getRadio(radioGroupQ2)
            val AR3 = getRadio(radioGroupQ3)
            val AR4 = getRadio(radioGroupQ4)

            if (Q1 != null) {
                if (tipeQ1 == "Text") {
                    Answer1 = input_text_Q1.text.toString()
                } else {
                    Answer1 = getRadio(radioGroupQ1)
                }
            }
            if (Q2 != null) {
                if (tipeQ2 == "Text") {
                    Answer2 = input_text_Q2.text.toString()
                } else {
                    Answer2 = getRadio(radioGroupQ2)
                }
            }
            if (Q3 != null) {
                if (tipeQ3 == "Text") {
                    Answer3 = input_text_Q3.text.toString()
                } else {
                    Answer3 = getRadio(radioGroupQ3)
                }
            }
            if (Q4 != null) {
                if (tipeQ4 == "Text") {
                    Answer4 = input_text_Q4.text.toString()
                } else {
                    Answer4 = getRadio(radioGroupQ4)
                }
            }
            retrofit.getTambahForm(IDLogin, NamaLogin, Q1, Answer1, Q2, Answer2, Q3, Answer3, Q4, Answer4)
                    .enqueue(object : retrofit2.Callback<PostFormModel> {
                        override fun onFailure(call: Call<PostFormModel>, t: Throwable) {
                            Log.d("gagal", "Gagal kirim form")

                        }

                        override fun onResponse(call: Call<PostFormModel>, response: Response<PostFormModel>) {
                            val data = response?.body()
                            val msg = data?.apiMessage
                            if (msg != "Send data Error") {
//                                 Toast.makeText(this@ChangePasswordActivity, msg, Toast.LENGTH_SHORT).show()
                                basicAlert(msg, "Selamat Form terkirim")

                            } else {
//                                 Toast.makeText(this@ChangePasswordActivity, msg, Toast.LENGTH_SHORT).show()
                                basicAlert(msg, "Maaf send data error")

                            }
                        }
                    })

        }
    }

    fun getRadio(radio: RadioGroup): String {
        val selected = radio.getCheckedRadioButtonId()
        val radiobutton = findViewById<RadioButton>(selected)
        return radiobutton.getText().toString()
    }

    fun cekForm(input: Any?): Any? {
        if (input != null) return input
        else return null
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
