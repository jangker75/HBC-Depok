package com.hbc.depok.view.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hbc.depok.R
import com.hbc.depok.databinding.ActivityLoginBinding
import com.hbc.depok.view.MainActivity
import com.hbc.depok.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
val TAG = "LoginActivity"
    private lateinit var viewmodel: LoginViewModel
    var binding: ActivityLoginBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding?.data = viewmodel

        observeViewModel()
    }

    private fun observeViewModel(){
        viewmodel.login.observe(this, Observer { user->
            if (user.apiStatus != 0){
                Log.d(TAG, "Data sukses $user")
                Toast.makeText(this, "welcome, ${user?.nama}", Toast.LENGTH_LONG).show()
                startActivity(Intent(application, MainActivity::class.java))
            }else{
                Log.d(TAG, "Data error $user")
                Toast.makeText(this, "Username atau Password Salah", Toast.LENGTH_LONG).show()
            }

        })
        viewmodel.loadingLogin.observe(this, Observer { Loading ->
            Loading?.let {
                loading.visibility = if (Loading) View.VISIBLE else View.GONE
            }
        })
    }

}
