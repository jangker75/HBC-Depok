package com.hbc.depok.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.hbc.depok.util.DataViewHolder
import com.hbc.depok.util.GlideApp
import com.hbc.depok.R
import kotlinx.android.synthetic.main.detail_member.*

class DetailMemberActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_member)

        val detailId = intent?.getStringExtra(DataViewHolder.MEMBER_ID_KEY)
        val detailNama = intent?.getStringExtra(DataViewHolder.MEMBER_NAMA_KEY)
        val detailSosmed = intent?.getStringExtra(DataViewHolder.MEMBER_SOSMED_KEY)
        val detailNoTelp = intent?.getStringExtra(DataViewHolder.MEMBER_NO_TELP_KEY)
        val detailNoPlat = intent?.getStringExtra(DataViewHolder.MEMBER_NO_PLAT_KEY)
        val Foto1 = intent?.getStringExtra(DataViewHolder.MEMBER_FOTO1_KEY)
        val Foto2 = intent?.getStringExtra(DataViewHolder.MEMBER_FOTO2_KEY)
        val Foto3 = intent?.getStringExtra(DataViewHolder.MEMBER_FOTO3_KEY)
        supportActionBar?.title = detailNama
        tvdetailId?.text = detailId
        tvdetailNama?.text = detailNama
        tvdetailSosmed?.text = detailSosmed
        tvdetailTelp?.text = detailNoTelp
        tvdetailPlat?.text = detailNoPlat
        setTitle("Member : "+detailNama)

        GlideApp.with(this).load(Foto1).placeholder(R.mipmap.ic_launcher).error(R.drawable.no_image).into(imgFoto1)
        GlideApp.with(this).load(Foto2).placeholder(R.mipmap.ic_launcher).error(R.drawable.no_image).into(imgFoto2)
        GlideApp.with(this).load(Foto3).placeholder(R.mipmap.ic_launcher).error(R.drawable.no_image).into(imgFoto3)
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
