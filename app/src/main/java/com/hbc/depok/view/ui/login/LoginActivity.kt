package com.hbc.depok.view.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.hbc.depok.R
import com.hbc.depok.databinding.ActivityLoginBinding
import com.hbc.depok.util.getProgressDrawable
import com.hbc.depok.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.member_fragment.*

class LoginActivity : AppCompatActivity(),LoginClickListener {
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
        viewmodel.loading.observe(this, Observer {loading->
            loading?.let {
                loadingView.visibility = if (loading) View.VISIBLE else View.GONE
            }

        })

        viewmodel.login.observe(this, Observer { user ->
            Toast.makeText(this, "welcome, ${user?.nama}", Toast.LENGTH_LONG).show()
        })
    }

    override fun submitOnClicked(v: View) {

    }
}
