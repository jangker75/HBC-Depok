package com.hbc.depok.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hbc.depok.R
import com.hbc.depok.view.ui.MemberListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container,MemberListFragment()).commit()
    }
}
