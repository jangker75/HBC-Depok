package com.hbc.depok

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.hbc.depok.api.masterAPI
import com.hbc.depok.model.GantiPassModel
import com.hbc.depok.network.ApiNetwork
import kotlinx.android.synthetic.main.content_change_password.*
import retrofit2.Call
import retrofit2.Response

class ChangePasswordActivity : AppCompatActivity() {
    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(applicationContext,
                android.R.string.yes, Toast.LENGTH_SHORT).show()
    }
    fun basicAlert(msg:String?, nama:String? ) {

        val builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("Message")
            setMessage("$nama, $msg")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
            show()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_change_password)
        val sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE)
        val IDLogin = sharedPreferences.getString("kd_anggota", "kd_anggota")
        val NamaLogin = sharedPreferences.getString("nama", "nama")
        val retrofit = masterAPI.getRetrofit.create(ApiNetwork::class.java)
        Log.d("IDLOGIN = ", IDLogin)
        btnSubmitChangePass.setOnClickListener {
            val oldPass = txtOldPass.text.toString()
            val NewPass = txtNewPass.text.toString()
            val ConfirmPass = txtConfirmPass.text.toString()
            if(oldPass.isEmpty()){
                txtOldPass.setError("Wajib Diisi")
            }else if(NewPass.isEmpty()){
                txtNewPass.setError("Wajib Diisi")
            }else if(ConfirmPass.isEmpty()){
                txtConfirmPass.setError("Wajib Diisi")
            }else if(NewPass != ConfirmPass){
                txtConfirmPass.setError("Confirm Password Tidak Sama")
            }else

                retrofit.getGantiPass(IDLogin,oldPass, NewPass)
                        .enqueue(object : retrofit2.Callback<GantiPassModel> {
                            override fun onFailure(call: Call<GantiPassModel>, t: Throwable) {
                                Log.d("gagal", "Ganti Password Gagal")
                                txtOldPass.text.clear()
                                txtConfirmPass.text.clear()
                                txtNewPass.text.clear()
                            }

                            override fun onResponse(call: Call<GantiPassModel>, response: Response<GantiPassModel>) {
                                val data = response?.body()
                                val msg = data?.apiMessage
                                if( msg != "Password lama anda salah"){
//                                 Toast.makeText(this@ChangePasswordActivity, msg, Toast.LENGTH_SHORT).show()
                                    basicAlert(msg, "Selamat "+data?.nama)
                                    txtOldPass.text.clear()
                                    txtConfirmPass.text.clear()
                                    txtNewPass.text.clear()
                                }else{
//                                 Toast.makeText(this@ChangePasswordActivity, msg, Toast.LENGTH_SHORT).show()
                                    basicAlert(msg, "Maaf "+NamaLogin)
                                    txtOldPass.text.clear()
                                    txtConfirmPass.text.clear()
                                    txtNewPass.text.clear()
                            }
                        }
                        })
        }
    }

    }
