package com.hbc.depok

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestOptions
import com.hbc.depok.FragmentSlide.FirstFragment
import com.hbc.depok.FragmentSlide.SecondFragment
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detail_member.*
import kotlinx.android.synthetic.main.fragment_first.*
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_third.*

class DetailMemberActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_member)

        val detailId = intent?.getStringExtra(DataViewHolder.MEMBER_ID_KEY)
        val detailNama = intent?.getStringExtra(DataViewHolder.MEMBER_NAMA_KEY)
        val detailAlamat = intent?.getStringExtra(DataViewHolder.MEMBER_ALAMAT_KEY)
        val detailNoTelp = intent?.getStringExtra(DataViewHolder.MEMBER_NO_TELP_KEY)
        val detailNoPlat = intent?.getStringExtra(DataViewHolder.MEMBER_NO_PLAT_KEY)

        //Get intent from main adapter
//        val FOTO1 = intent.getStringExtra(DataViewHolder.MEMBER_FOTO1_KEY)
//        val FOTO2 = intent.getStringExtra(DataViewHolder.MEMBER_FOTO2_KEY)
        //deklarasi intent dari main adapter
//        val fot1: String = FOTO1
//        val fot2: String = FOTO2
//        //kirim intent ke masing2 fragment
////        val intent1 = Intent(applicationContext, FirstFragment::class.java)
////        val intent2 = Intent(applicationContext,SecondFragment::class.java)
//        intent1.putExtra("FOTO 1", fot1)
//        intent2.putExtra("FOTO 2", fot2)
//kirim intent
//        startActivity(intent1)
//        startActivity(intent2)
//
        supportActionBar?.title = detailNama
        tvdetailId?.text = detailId
        tvdetailNama?.text = detailNama
        tvdetailAlamat?.text = detailAlamat
        tvdetailTelp?.text = detailNoTelp
        tvdetailPlat?.text = detailNoPlat

//        val options : RequestOptions = RequestOptions()
//                .error(R.mipmap.ic_launcher)
//                .placeholder(R.mipmap.ic_launcher)



        //        Glide.with(this).load(FOTO1).apply(options).into(imageFirst)
//        Glide.with(this).load(FOTO2).apply(options).into(imageSecond)
        //   Glide.with(this).load(R.mipmap.ic_launcher).apply(options).into(imageThird)
        //    if(FOTO().foto3 == null)  Glide.with(this).load(R.mipmap.ic_launcher).into(imageThird)
        //     else Glide.with(this).load(FOTO().foto3).apply(options).into(imageThird)
//        if (FOTO().foto1 != null) {
//            Glide.with(this).load(FOTO().foto1).apply(options).into(imageFirst)
//        } else  Glide.with(this).load(R.mipmap.ic_launcher).into(imageFirst)
//        if (FOTO().foto2 != null) {
//            Glide.with(this).load(FOTO().foto2).apply(options).into(imageSecond)
//        } else  Glide.with(this).load(R.mipmap.ic_launcher).into(imageSecond)
//        if (FOTO().foto3 != null) {
//            Glide.with(this).load(FOTO().foto3).apply(options).into(imageThird)
//        } else  Glide.with(this).load(R.mipmap.ic_launcher).into(imageThird)
//        else if (FOTO().foto2 != null) Glide.with(this).load(FOTO()?.foto2).into(imageSecond)
//        else if (FOTO().foto3 != null) Glide.with(this).load(FOTO()?.foto3).into(imageThird)
        val adapter = MyPagerAdapter(supportFragmentManager)
        adapter.addFragment(FirstFragment(), "Foto 1")
        adapter.addFragment(SecondFragment(), "Foto 2")
        //        // Initialize the MoviesPagerAdapter
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }

//    inner class FOTO {
//        val foto1: String? = intent.getStringExtra(DataViewHolder.MEMBER_FOTO1_KEY)
//        var foto2: String? = intent.getStringExtra(DataViewHolder.MEMBER_FOTO2_KEY)
    //     var foto3: String? = intent.getStringExtra(DataViewHolder.MEMBER_FOTO3_KEY)
    //var foto4: String? = intent.getStringExtra(DataViewHolder.MEMBER_FOTO4_KEY)
    //  var foto5: String? = intent.getStringExtra(DataViewHolder.MEMBER_FOTO5_KEY)


    //   }


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
