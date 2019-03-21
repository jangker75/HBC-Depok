package com.hbc.depok

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.widget.Button
import android.widget.ImageView
import com.hbc.depok.api.masterAPI
import com.hbc.depok.network.ApiNetwork
import com.hbc.depok.ui.DetailArtikelActivity
import com.hbc.depok.util.MainAdapter
import kotlinx.android.synthetic.main.activity_article.*
import kotlinx.android.synthetic.main.activity_main.*

class MenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val intent = Intent(this, DetailArtikelActivity::class.java)
        val imageView = findViewById<ImageView>(R.id.article)
        val imgResId = R.drawable.article
        var resId = imgResId
        imageView.setImageResource(imgResId)

        val button = findViewById<Button>(R.id.buttonarticle)
        button?.setOnClickListener {
            resId = if (resId == R.drawable.article) R.mipmap.article else R.drawable.article
            imageView.setImageResource(resId)
            startActivity(intent)
            this@MenuActivity.finish()
        }
        val intent1 = Intent(this, MainActivity::class.java)
        val imageView1 = findViewById<ImageView>(R.id.list)
        val imgRestId = R.drawable.list
        var restId = imgRestId
        imageView1.setImageResource(imgRestId)

        val button1 = findViewById<Button>(R.id.buttonlistm)
        button1?.setOnClickListener {
            restId = if (restId == R.drawable.list) R.mipmap.list else R.drawable.list
            imageView1.setImageResource(restId)
            startActivity(intent1)
            this@MenuActivity.finish()
        }
    }
}
