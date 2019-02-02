package com.hbc.depok

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainAdapter : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    private val data: MutableList<Data> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_data_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val txtID: TextView = holder.itemView.findViewById(R.id.txtID)
        val txtNama: TextView = holder.itemView.findViewById(R.id.txtNama)
        val txtPlat: TextView = holder.itemView.findViewById(R.id.txtPlat)
        //    val movieAvatarImage : ImageView = itemView.findViewById(R.id.movieAvatar)

        fun bindModel(data: Data) {
            txtID.text = data.kode_anggota
            txtNama.text = data.Nama
            txtPlat.text = data.No_plat
            //   Picasso.get().load(data.foto).into(imgView)
        }
        bindModel(data[position])


    }

    fun setData(datas: List<Data>) {
        data.addAll(datas)
        notifyDataSetChanged()
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }
}