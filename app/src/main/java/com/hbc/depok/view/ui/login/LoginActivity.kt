package com.hbc.depok.view.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.hbc.depok.R

class LoginActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        // supportFragmentManager.beginTransaction().replace(R.id.containerLogin, LoginFragment()).commit()
        navController = Navigation.findNavController(this, R.id.containerLogin)
        NavigationUI.setupActionBarWithNavController(this, navController)
//        preferenceHelper = PreferenceHelper(this)

//        if (preferenceHelper!!.getIsLogin())
//        {
//            val intent = Intent(this@LoginActivity, MainActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
//            preferenceHelper!!.putIsLogin(true)
//            startActivity(intent)
//            this.finish()
//        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController, null)
    }


}
