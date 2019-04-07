package com.hbc.depok

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log.d
import android.widget.Toast
import com.hbc.depok.api.masterAPI.getRetrofit
import com.hbc.depok.model.ArticleModel
import com.hbc.depok.model.GantiPassModel
import com.hbc.depok.model.LoginModel
import com.hbc.depok.network.ApiNetwork
import com.hbc.depok.ui.DetailArtikelActivity
import com.hbc.depok.util.DataViewHolderArticle
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response

/**
 * A login screen that offers login via email/password.
 */
class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        var gantiPass: GantiPassModel? = null
        val sharedPreferences = getSharedPreferences("myprefs", Context.MODE_PRIVATE)
        val intent = Intent(this, MenuActivity::class.java)
        val editor = sharedPreferences.edit()
        val retrofit = getRetrofit.create(ApiNetwork::class.java)
        editor.remove("kd_anggota")
        editor.remove("nama")
        btnSubmit.setOnClickListener {
            val kdAnggota = ETkodeAnggota.text.toString()
            val password = ETpassword.text.toString()
            if(kdAnggota.isEmpty()){
                ETkodeAnggota.setError("Kode Anggota Wajib Diisi")
            }else if(password.isEmpty()){
            ETpassword.setError("Password Wajib Diisi")
        }else

            retrofit.getLogin(kdAnggota, password)
                    .enqueue(object : retrofit2.Callback<LoginModel> {
                        override fun onFailure(call: Call<LoginModel>, t: Throwable) {
                            d("gagal", "LOGIN GAGAL")
                        }

                        override fun onResponse(call: Call<LoginModel>, response: Response<LoginModel>) {
                            val data = response?.body()
                            val msg = data?.apiMessage
                            if( msg != "Login berhasil"){
                                Toast.makeText(this@LoginActivity, msg, Toast.LENGTH_SHORT).show()
                            }else{
                                editor.putString("kd_anggota",kdAnggota )
                                editor.putString("nama",data.nama )
                                editor.apply()
                                Toast.makeText(this@LoginActivity, msg, Toast.LENGTH_SHORT).show()
                                startActivity(intent)
                                this@LoginActivity.finish()                            }

                        }

                    })
        }
    }


}
