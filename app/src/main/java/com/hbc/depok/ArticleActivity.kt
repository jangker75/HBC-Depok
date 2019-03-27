package com.hbc.depok

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.hbc.depok.api.masterAPI
import com.hbc.depok.network.ApiNetwork
import com.hbc.depok.util.ArticleAdapter
import com.hbc.depok.util.MainAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_article.*
import java.util.*


class ArticleActivity : AppCompatActivity() {
    private lateinit var articleAdapter: ArticleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        articleAdapter = ArticleAdapter()
        rv_artikel.layoutManager = LinearLayoutManager(this)
        rv_artikel.adapter = articleAdapter

        val swipeRefreshLayout = findViewById(R.id.swipelayoutArticle) as SwipeRefreshLayout


        swipeRefreshLayout.setColorSchemeResources(R.color.refresh, R.color.refresh1, R.color.refresh2)
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = true
            Handler().postDelayed(Runnable {
                swipeRefreshLayout.isRefreshing = false

                val min = 65
                val max = 95
                val random = Random()
                val i = random.nextInt(max - min + 1) + min
            }, 3000)
        }


        val retrofit = masterAPI.getRetrofit.create(ApiNetwork::class.java)
        retrofit.getArtikel()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { articleAdapter.setData(it.data) },
                        {
                            Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
                        })
    }
}

