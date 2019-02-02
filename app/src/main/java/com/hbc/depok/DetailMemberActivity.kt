package com.hbc.depok

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_member.*

class DetailMemberActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_member)

        val detailId = intent?.getStringExtra(DataViewHolder.MEMBER_ID_KEY)
        val detailNama = intent?.getStringExtra(DataViewHolder.MEMBER_NAMA_KEY)
        val detailAlamat = intent?.getStringExtra(DataViewHolder.MEMBER_ALAMAT_KEY)
        val detailNoTelp = intent?.getStringExtra(DataViewHolder.MEMBER_NO_TELP_KEY)
        val detailNoPlat = intent?.getStringExtra(DataViewHolder.MEMBER_NO_PLAT_KEY)

        supportActionBar?.title = detailNama
        tvdetailId?.text = detailId
        tvdetailNama?.text = detailNama
        tvdetailAlamat?.text = detailAlamat
        tvdetailTelp?.text = detailNoTelp
        tvdetailPlat?.text = detailNoPlat

       viewPager.adapter = MyPagerAdapter(supportFragmentManager)

        // Initialize the MoviesPagerAdapter

    }
// inner class FOTO {
//        var foto1: String = intent.getStringExtra(DataViewHolder.MEMBER_FOTO1_KEY)
//        var foto2: String = intent.getStringExtra(DataViewHolder.MEMBER_FOTO2_KEY)
//        var foto3: String? = intent.getStringExtra(DataViewHolder.MEMBER_FOTO3_KEY)
//        var foto4: String? = intent.getStringExtra(DataViewHolder.MEMBER_FOTO4_KEY)
//        var foto5: String? = intent.getStringExtra(DataViewHolder.MEMBER_FOTO5_KEY)
//    }

}




