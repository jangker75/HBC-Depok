package com.hbc.depok.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.util.Log.d
import android.widget.Toast
import com.hbc.depok.MainActivity
import com.hbc.depok.R
import com.hbc.depok.api.masterAPI.getRetrofit
import com.hbc.depok.model.LoginModel
import com.hbc.depok.network.ApiNetwork
import com.hbc.depok.util.SharedPreference
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        val pref: SharedPreference = SharedPreference(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val intent = Intent(this, MainActivity::class.java)
        val retrofit = getRetrofit.create(ApiNetwork::class.java)

        if (pref.getValueString("isLogin")==null){
            pref.save("isLogin","belum")
        }else if (pref.getValueString("isLogin")=="sudah"){
                startActivity(intent)
                this@LoginActivity.finish()

            }
val myPref=pref.getValueString("isLogin")
//        var myPref = pref.getValueString("isLogin")
 Log.v("TAG", "My token is: $myPref")
        btnSubmit.setOnClickListener {
            val kdAnggota = ETkodeAnggota.text.toString()
            val password = ETpassword.text.toString()
            if (kdAnggota.isEmpty()) {
                ETkodeAnggota.setError("Kode Anggota Wajib Diisi")
            } else if (password.isEmpty()) {
                ETpassword.setError("Password Wajib Diisi")
            } else

                retrofit.getLogin(kdAnggota, password)
                        .enqueue(object : retrofit2.Callback<LoginModel> {
                            override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                                d("gagal", "LOGIN GAGAL")
                            }

                            override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                                val data = response?.body()
                                val msg = data?.apiMessage
                                if (msg != "Login berhasil") {
                                    Toast.makeText(this@LoginActivity, msg, Toast.LENGTH_SHORT).show()
                                } else {
                              pref.save("isLogin","sudah")
                                    Toast.makeText(this@LoginActivity, msg, Toast.LENGTH_SHORT).show()
                                    startActivity(intent)
                                    this@LoginActivity.finish()
                                }

                            }

                        })
        }
    }


}
