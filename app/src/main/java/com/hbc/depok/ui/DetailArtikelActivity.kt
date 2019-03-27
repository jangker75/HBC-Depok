package com.hbc.depok.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import com.hbc.depok.util.DataViewHolder
import com.hbc.depok.R
import com.hbc.depok.util.DataViewHolderArticle
import com.hbc.depok.util.GlideApp
import kotlinx.android.synthetic.main.detail_artikel.*
import kotlinx.android.synthetic.main.detail_member.*

class DetailArtikelActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_artikel)

        val detailTitleArticle = intent?.getStringExtra(DataViewHolderArticle.ARTICLE_TITLEARTICLE_KEY)
        val detailContentArticle = intent?.getStringExtra(DataViewHolderArticle.ARTICLE_CONTENT_KEY)
        val detailFotoArticle = intent?.getStringExtra(DataViewHolderArticle.ARTICLE_FOTOARTICLE_KEY)
        val detailTanggalArticle= intent?.getStringExtra(DataViewHolderArticle.ARTICLE_TANGGALARTICLE_KEY)
        supportActionBar?.title = detailTitleArticle
        tvTanggalTerbit?.text = detailTanggalArticle
        tvdetailtitle?.text = detailTitleArticle
        tvdetailcontent?.text = detailContentArticle
        GlideApp.with(this).load(detailFotoArticle).placeholder(R.mipmap.ic_launcher).error(R.drawable.no_image).into(imgImageArticle)
    }

    }

