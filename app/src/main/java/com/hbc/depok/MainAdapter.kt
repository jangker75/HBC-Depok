package com.hbc.depok

import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

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
        //    val movieAvatarImage : ImageView = itemView.findViewById(R.id.movieAvatar)
        holder?.data=data[position]

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


}
class DataViewHolder(itemView: View, var data:Data? = null) : RecyclerView.ViewHolder(itemView) {

     companion object {
         val MEMBER_ID_KEY = "ID"
         val MEMBER_NAMA_KEY = "NAMA"
         val MEMBER_ALAMAT_KEY = "ALAMAT"
         val MEMBER_NO_TELP_KEY = "NO TELP"
         val MEMBER_NO_PLAT_KEY = "NO PLAT"
         val MEMBER_FOTO1_KEY = "FOTO1"
         val MEMBER_FOTO2_KEY = "FOTO2"
         val MEMBER_FOTO3_KEY = "FOTO3"
         val MEMBER_FOTO4_KEY = "FOTO4"
         val MEMBER_FOTO5_KEY = "FOTO5"

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
            intent.putExtra(MEMBER_FOTO4_KEY, data?.foto4)
            intent.putExtra(MEMBER_FOTO5_KEY, data?.foto5)

            itemView.context.startActivity(intent)
            println("TEST")
        }
    }

}
class MyPagerAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){

    // sebuah list yang menampung objek Fragment
    private val pages = listOf(
            FirstFragment(),
            SecondFragment()
         //   ThridFragment()
    )

    // menentukan fragment yang akan dibuka pada posisi tertentu
    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    // judul untuk tabs
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "First Tab"
            1 -> "Second Tab"
            else -> "Third Tab"
        }
    }
}