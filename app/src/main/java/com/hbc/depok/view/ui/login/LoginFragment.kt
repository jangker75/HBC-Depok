package com.hbc.depok.view.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.hbc.depok.R
import com.hbc.depok.databinding.LoginFragmentBinding
import com.hbc.depok.view.MainActivity
import com.hbc.depok.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.login_fragment.*


class LoginFragment : Fragment() {
    val TAG = "LoginActivity"

    private lateinit var viewmodel: LoginViewModel
    //    private var preferenceHelper: PreferenceHelper? = null
    private lateinit var binding: LoginFragmentBinding

    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // return inflater.inflate(R.layout.login_fragment, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.login_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //      binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewmodel = ViewModelProviders.of(this).get(LoginViewModel::class.java)
        binding.data = viewmodel
        btn_register.setOnClickListener {
            viewmodel.registerOnClicked(it)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewmodel.login.observe(this, Observer { user ->
            if (user.apiStatus != 0) {
                Log.d(TAG, "Data sukses $user")
                Toast.makeText(context, "welcome, ${user?.nama}", Toast.LENGTH_LONG).show()
                val intent = Intent(activity, MainActivity::class.java)
                startActivity(intent)
                finishActivity()
//                val intent = Intent(this@LoginFragment, MainActivity::class.java)
//                startActivity(Intent(intent))

            } else {
                Log.d(TAG, "Data error $user")
                Toast.makeText(context, "Username atau Password Salah", Toast.LENGTH_LONG).show()
            }

        })
        viewmodel.loadingLogin.observe(this, Observer { Loading ->
            Loading?.let {
                loading.visibility = if (Loading) View.VISIBLE else View.GONE
            }
        })
    }


    private fun finishActivity() {
        if (getActivity() != null) {
            getActivity()!!.finish();
        }
    }
}
