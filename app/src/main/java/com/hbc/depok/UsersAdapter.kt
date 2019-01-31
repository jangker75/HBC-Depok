package com.hbc.depok

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_data_layout.view.*

class UsersAdapter : RecyclerView.Adapter<UsersAdapter.CustomViewHolder>() {

    private val data: MutableList<Data> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CustomViewHolder {
        val isiData = LayoutInflater.from(parent?.context).inflate(R.layout.item_data_layout, parent, false)
        //   return CustomViewHolder(isiData)
        return CustomViewHolder(isiData)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CustomViewHolder?, position: Int) {
        val data = data.get(position)
        holder?.view?.txtID?.text = data.kode_anggota
        holder?.view?.txtNama?.text = data.Nama
        holder?.view?.txtPlat?.text = data.No_Telp
        // holder.bindModel(data[position])
        val imgFoto1 = holder?.view?.imgView
        Picasso.get().load(data.foto1).into(imgFoto1)
    }

    fun setData(datas: List<Data>) {
        data.addAll(datas)
        notifyDataSetChanged()
    }

    inner class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.setOnClickListener {
                val intent = Intent(view.context, DetailMemberActivity::class.java)
                view.context.startActivity(intent)
            }

        }
    }
}

//class CustomViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
//    init {
//       view.setOnClickListener {
//           val intent = Intent(view.context, DetailMemberActivity::class.java)
//          view.context.startActivity(intent)
//       }

//   }

//}
