package com.hbc.depok

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.SearchView
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.hbc.depok.ui.DetailArtikelActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {
    private var searchView: SearchView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val intentArtikel = Intent(this, ArticleActivity::class.java)
        btnArticle.setOnClickListener {
            Toast.makeText(this, "List Member", Toast.LENGTH_SHORT).show()
            startActivity(intentArtikel)
        this.finish()
        }

        val intentMember = Intent(this, MainActivity::class.java)
        btnArticle.setOnClickListener {
            Toast.makeText(this, "List Artikel", Toast.LENGTH_SHORT).show()
            startActivity(intentMember)
        }

    }
    override fun onBackPressed() {
        // close search view on back button pressed
        if (!searchView!!.isIconified) {
            searchView!!.isIconified = true
            return
        }

        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you sure!")
        builder.setMessage("Do you want to close the app?")
        builder.setPositiveButton("Yes", { dialogInterface: DialogInterface, i: Int ->
            finish()
        })
        builder.setNegativeButton("No", { dialogInterface: DialogInterface, i: Int -> })
        builder.show()
    }
}
