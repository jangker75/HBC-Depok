package com.hbc.depok.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hbc.depok.R
import com.hbc.depok.databinding.MemberItemBinding
import com.hbc.depok.model.DataMember
import com.hbc.depok.view.ui.listmember.MemberClickListener

class ListMemberAdapter() :
        RecyclerView.Adapter<ListMemberAdapter.MemberViewHolder>(), MemberClickListener {

    private val data: MutableList<DataMember> = mutableListOf()
//    private val data: MutableList<MemberModel> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val dataBinding =
                DataBindingUtil.inflate<MemberItemBinding>(inflater, R.layout.member_item, parent, false)
        return MemberViewHolder(dataBinding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        holder.view.member = data[position]
        holder.view.listener = this
    }

    class MemberViewHolder(var view: MemberItemBinding) : RecyclerView.ViewHolder(view.root) {
//        fun bindView(get: DataMember) {
//            itemView.namaMember.text = get.nama
//            itemView.platMember.text = get.noPlat
//            Picasso.get().load(get.foto1)
//                    .placeholder(R.mipmap.ic_launcher)
//                    .error(R.mipmap.ic_launcher)
//                    .into(itemView.imgFoto)
//
//        }
    }

    fun updateMemberList(newMemberList: List<DataMember>) {
        data.clear()
        data.addAll(newMemberList)
        notifyDataSetChanged()
    }

    override fun memberOnClicked(v: View) {
     Log.d("Adapter on click","Ini di klik ")

    }
}