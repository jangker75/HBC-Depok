package com.hbc.depok.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.hbc.depok.util.DataViewHolder
import com.hbc.depok.util.GlideApp
import com.hbc.depok.R
import kotlinx.android.synthetic.main.detail_artikel.*

class DetailArtikelActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_artikel)

        val detailtitle = intent?.getStringExtra(DataViewHolder.MEMBER_title_KEY)
        val detailcontent = intent?.getStringExtra(DataViewHolder.MEMBER_content_KEY)
        val image = intent?.getStringExtra(DataViewHolder.MEMBER_image_KEY)
        supportActionBar?.title = detailtitle
        tvdetailtitle?.text = detailtitle
        tvdetailcontent?.text = detailcontent
        setTitle("Member : "+detailtitle)

        GlideApp.with(this).load(image).placeholder(R.mipmap.ic_launcher).error(R.drawable.no_image).into(imgimage)

//        val adapter = MyPagerAdapter(supportFragmentManager)
//        adapter.addFragment(FirstFragment(), "Foto 1")
//        adapter.addFragment(SecondFragment(), "Foto 2")
//        //        // Initialize the MoviesPagerAdapter
//        viewPager.adapter = adapter
//        tabs.setupWithViewPager(viewPager)
    }



    inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        private val fragmentList: MutableList<Fragment> = ArrayList()
        private val titleList: MutableList<String> = ArrayList()

        // menentukan fragment yang akan dibuka pada posisi tertentu
        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
    }

}
