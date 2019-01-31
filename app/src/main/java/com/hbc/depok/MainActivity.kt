package com.hbc.depok

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var usersAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        usersAdapter = UsersAdapter()
        rv_recycler.layoutManager = LinearLayoutManager(this)
        //rv_recycler.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        rv_recycler.adapter = usersAdapter

        fetchJson()
    }

    fun fetchJson() {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl("http://hbcdepok.com/data/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        val apiData = retrofit.create(ApiNetwork::class.java)
        apiData.getData()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ usersAdapter.setData(it.data) },
                        {
                            Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
                        })
    }
    //   private fun partItemClicked(partItem : Data) {
    //       Toast.makeText(this, "Clicked: ${partItem.kode_anggota}", Toast.LENGTH_LONG).show()

    // Launch second activity, pass part ID as string parameter
//        val showDetailActivityIntent = Intent(this, DetailMemberActivity::class.java)
    //       showDetailActivityIntent.putExtra(Intent.EXTRA_TEXT, partItem.kode_anggota)
    //       startActivity(showDetailActivityIntent)
    //   }

}
