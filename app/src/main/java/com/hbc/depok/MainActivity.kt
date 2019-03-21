package com.hbc.depok

import android.app.AlertDialog
import android.app.SearchManager
import android.content.Context
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.widget.Toast
import com.hbc.depok.api.masterAPI.getRetrofit
import com.hbc.depok.network.ApiNetwork
import com.hbc.depok.util.MainAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var mainAdapter: MainAdapter
    private var searchView: SearchView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainAdapter = MainAdapter()
        rv_recycler.layoutManager = LinearLayoutManager(this)
        rv_recycler.adapter = mainAdapter

        val swipeRefreshLayout = findViewById(R.id.swipelayout) as SwipeRefreshLayout


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


        val retrofit = getRetrofit.create(ApiNetwork::class.java)

        retrofit.getData()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ mainAdapter.setData(it.data) },
                        {
                            Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()
                        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)

        // Associate search_layout configuration with the SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        searchView = menu.findItem(R.id.action_search)
                .actionView as SearchView
        searchView!!.setSearchableInfo(searchManager
                .getSearchableInfo(componentName))
        searchView!!.maxWidth = Integer.MAX_VALUE

        // listening to search query text change
        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // filter recycler view when query submitted
                mainAdapter!!.filter.filter(query)
                return false
            }

            override fun onQueryTextChange(query: String): Boolean {
                // filter recycler view when text is changed
                mainAdapter!!.filter.filter(query)
                return false
            }
        })
        return true
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


