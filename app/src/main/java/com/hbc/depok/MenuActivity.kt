package com.hbc.depok

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu)

        val intentArtikel = Intent(this, ArticleActivity::class.java)
        btnArticle.setOnClickListener {
            Toast.makeText(this, "List Artikel", Toast.LENGTH_SHORT).show()
            startActivity(intentArtikel)
        }

        val intentMember = Intent(this, MainActivity::class.java)
        btnMember.setOnClickListener {
            Toast.makeText(this, "List Member", Toast.LENGTH_SHORT).show()
            startActivity(intentMember)
        }

        val intentChangePass = Intent(this, ChangePasswordActivity::class.java)
        btnChangePassword.setOnClickListener {
            Toast.makeText(this, "Ganti Password", Toast.LENGTH_SHORT).show()
            startActivity(intentChangePass)
        }

        val intentFormResign = Intent(this, FormActivity::class.java)
        btnFormResign.setOnClickListener {
            Toast.makeText(this, "Isi Form", Toast.LENGTH_SHORT).show()
            startActivity(intentFormResign)
        }

    }

}
