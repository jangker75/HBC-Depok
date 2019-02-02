package com.hbc.depok

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.detail_member.*
import kotlinx.android.synthetic.main.item_data_layout.*
import kotlinx.android.synthetic.main.item_data_layout.view.*

class DetailMemberActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //   rv_recycler.setBackgroundColor(Color.RED)
        rv_recycler.layoutManager = LinearLayoutManager(this)
        rv_recycler.adapter = DetailMemberAdapter()
    }

    private class DetailMemberAdapter : RecyclerView.Adapter<DetailMemberViewHolder>() {
        private val data: MutableList<Data> = mutableListOf()
        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DetailMemberViewHolder {

            val layoutInflater = LayoutInflater.from(parent?.context)
            val memberView = layoutInflater.inflate(R.layout.detail_member, parent, false)
            // dmView.setBackgroundColor(Color.BLUE)
            //      dmView.minimumHeight = 50
            return DetailMemberViewHolder(memberView)
        }

        override fun getItemCount(): Int {
            return 1
        }

        override fun onBindViewHolder(holder: DetailMemberViewHolder?, position: Int) {
       //     val data = data.get(position)
         //   holder?.customView?.txtID?.text = data.kode_anggota
        //    holder?.customView?.txtNama?.text = data.Nama
          //  holder?.customView?.txtPlat?.text = data.No_Telp
            // holder.c(data[position])
      //      val imgFoto1 = holder?.customView?.imgView
      //      Picasso.get().load(data.foto1).into(imgFoto1)
        }


    }

    private class DetailMemberViewHolder(val customView: View) : RecyclerView.ViewHolder(customView) {

    }
}