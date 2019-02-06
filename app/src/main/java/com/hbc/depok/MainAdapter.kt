package com.hbc.depok

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hbc.depok.FragmentSlide.FirstFragment
import com.hbc.depok.FragmentSlide.SecondFragment
import com.hbc.depok.R.id.imageFirst
import kotlinx.android.synthetic.main.fragment_first.*

class MainAdapter : RecyclerView.Adapter<DataViewHolder>() {

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
        val imageTumb: ImageView = holder?.itemView.findViewById(R.id.imgView)
        holder?.data = data[position]

        fun bindModel(data: Data) {
            txtID.text = data.kode_anggota
            txtNama.text = data.Nama
            txtPlat.text = data.No_plat

            //  val options: RequestOptions = RequestOptions().error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher)
            GlideApp.with(holder.itemView.context)
                    .load(data.foto1)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageTumb)
            // Glide.with(holder?.itemView?.context).load(data.foto1).apply(options).into(imageTumb)
            //  Picasso.get(holder?.itemView.context).load(data.foto1).into(imageTumb)
        }
        bindModel(data[position])


    }

    fun setData(datas: List<Data>) {
        data.addAll(datas)
        notifyDataSetChanged()
    }


}

class DataViewHolder(itemView: View, var data: Data? = null) : RecyclerView.ViewHolder(itemView) {

    companion object {
        val MEMBER_ID_KEY = "ID"
        val MEMBER_NAMA_KEY = "NAMA"
        val MEMBER_ALAMAT_KEY = "ALAMAT"
        val MEMBER_NO_TELP_KEY = "NO TELP"
        val MEMBER_NO_PLAT_KEY = "NO PLAT"
        val MEMBER_FOTO1_KEY = "FOTO1"
        val MEMBER_FOTO2_KEY = "FOTO2"
        val MEMBER_FOTO3_KEY = "FOTO3"
        //    val MEMBER_FOTO4_KEY = "FOTO4"
        //    val MEMBER_FOTO5_KEY = "FOTO5"

    }

    init {
        itemView.setOnClickListener {


            val intent = Intent(itemView.context, DetailMemberActivity::class.java)

            intent.putExtra(MEMBER_ID_KEY, data?.kode_anggota)
            intent.putExtra(MEMBER_NAMA_KEY, data?.Nama)
            intent.putExtra(MEMBER_ALAMAT_KEY, data?.Alamat)
            intent.putExtra(MEMBER_NO_TELP_KEY, data?.No_Telp)
            intent.putExtra(MEMBER_NO_PLAT_KEY, data?.No_plat)
            intent.putExtra(MEMBER_FOTO1_KEY, data?.foto1)
            intent.putExtra(MEMBER_FOTO2_KEY, data?.foto2)
            intent.putExtra(MEMBER_FOTO3_KEY, data?.foto3)
//            val FOTO1 :String? = data?.foto1
//            val FOTO2 :String? = data?.foto2
//            val bundle1 = Bundle()
           // val bundle2 = Bundle()
//            bundle1.putString("IMAGE1", FOTO1)
           // bundle2.putString("IMAGE2", FOTO2)

//            val Frag1 = FirstFragment()
//            val Frag2 = SecondFragment()
//            bundle1.putString("FOTO 1", foto1)
//            bundle2.putString("FOTO 2", FOTO2)
        //    SecondFragment().setArguments(bundle2)
//            FirstFragment().setArguments(bundle1)
//            println("FOTO 1 sebelum dikirim ke fragment = " + FOTO1)
//            println("FOTO 2 sebelum dikirim ke fragment = " + FOTO2)
//            println("Bundle 1 sebelum dikirim ke fragment = " + bundle1)
        //    println("Bundle 2 sebelum dikirim ke fragment = " + bundle2)

            itemView.context.startActivity(intent)
        }
    }
}

