package com.hbc.depok.util

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import com.hbc.depok.MemberModel
import com.hbc.depok.R
import com.hbc.depok.model.ArticleModel
import com.hbc.depok.util.GlideApp
import com.hbc.depok.ui.DetailMemberActivity
import java.util.ArrayList

class MainAdapter : RecyclerView.Adapter<DataViewHolder>(),Filterable {
    private var memberSearchList:MutableList<MemberModel> = mutableListOf()
//  private var memberSearchList: List<Data>? = null
    private val data: MutableList<MemberModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        return DataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_data_layout, parent, false))
    }
init {
    memberSearchList = data
}
    override fun getItemCount(): Int {
        return memberSearchList!!.size
    }
    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): Filter.FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    memberSearchList=data
                } else {
                    var filteredList = arrayListOf<MemberModel>()
                    for (row in data) {

                        if (row.No_plat!!.toLowerCase().contains(charString.toLowerCase())||row.Nama!!.toLowerCase().contains(charString.toLowerCase()) || row.kode_anggota!!.contains(charSequence)) {
                            filteredList.add(row)
                        }
                    }

                    memberSearchList = filteredList
                }

                val filterResults = Filter.FilterResults()
                filterResults.values = memberSearchList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: Filter.FilterResults) {
                memberSearchList = filterResults.values as ArrayList<MemberModel>
                notifyDataSetChanged()
            }
        }
    }
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val member = memberSearchList!![position]
        holder.txtId.text = member.kode_anggota
        holder.txtNama.text = member.Nama
        holder.txtPlat.text = member.No_plat
        GlideApp.with(holder.itemView.context)
                .load(member.foto1)
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageTumb)
//        val txtID: TextView = holder.itemView.findViewById(R.id.txtID)
//        val txtNama: TextView = holder.itemView.findViewById(R.id.txtNama)
//        val txtPlat: TextView = holder.itemView.findViewById(R.id.txtPlat)
//        val imageTumb: ImageView = holder?.itemView.findViewById(R.id.imgView)
        holder?.member = memberSearchList[position]

//        fun bindModel(data: Data) {
//            txtID.text = data.kode_anggota
//            txtNama.text = data.Nama
//            txtPlat.text = data.No_plat
//
//            //  val options: RequestOptions = RequestOptions().error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher)
//            GlideApp.with(holder.itemView.context)
//                    .load(data.foto1)
//                    .placeholder(R.mipmap.ic_launcher)
//                    .into(imageTumb)
//            // Glide.with(holder?.itemView?.context).load(data.foto1).apply(options).into(imageTumb)
//            //  Picasso.get(holder?.itemView.context).load(data.foto1).into(imageTumb)
//        }
//        bindModel(data[position])


    }

    fun setData(datas: List<MemberModel>) {
        data.addAll(datas)
        notifyDataSetChanged()
    }


}

class DataViewHolder(itemView: View, var member: MemberModel? = null) : RecyclerView.ViewHolder(itemView) {
    var txtId: TextView
    var txtNama: TextView
    var txtPlat: TextView
    var imageTumb:ImageView
    companion object {
        val MEMBER_ID_KEY = "ID"
        val MEMBER_NAMA_KEY = "NAMA"
        val MEMBER_SOSMED_KEY = "ALAMAT"
        val MEMBER_NO_TELP_KEY = "NO TELP"
        val MEMBER_NO_PLAT_KEY = "NO PLAT"
        val MEMBER_FOTO1_KEY = "FOTO1"
        val MEMBER_FOTO2_KEY = "FOTO2"
        val MEMBER_FOTO3_KEY = "FOTO3"

        //    val MEMBER_FOTO4_KEY = "FOTO4"
        //    val MEMBER_FOTO5_KEY = "FOTO5"

    }

    init {
        imageTumb = itemView.findViewById(R.id.imgView)
        txtId = itemView.findViewById(R.id.txtID)
        txtNama = itemView.findViewById(R.id.txtNama)
        txtPlat = itemView.findViewById(R.id.txtPlat)
        itemView.setOnClickListener {


            val intent = Intent(itemView.context, DetailMemberActivity::class.java)

            intent.putExtra(MEMBER_ID_KEY, member?.kode_anggota)
            intent.putExtra(MEMBER_NAMA_KEY, member?.Nama)
            intent.putExtra(MEMBER_SOSMED_KEY, member?.sosmed)
            intent.putExtra(MEMBER_NO_TELP_KEY, member?.No_Telp)
            intent.putExtra(MEMBER_NO_PLAT_KEY, member?.No_plat)
            intent.putExtra(MEMBER_FOTO1_KEY, member?.foto1)
            intent.putExtra(MEMBER_FOTO2_KEY, member?.foto2)
            intent.putExtra(MEMBER_FOTO3_KEY, member?.foto3)
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

