package com.hbc.depok.FragmentSlide


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.hbc.depok.DetailMemberActivity
import com.hbc.depok.GlideApp

import com.hbc.depok.R
import kotlinx.android.synthetic.main.fragment_first.*

class FirstFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val foto1 = this.arguments?.getString("FOTO 1")
        println("FOTO 1 di fragment = " +foto1)
        if (foto1 == null)
            Glide.with(this).load(R.mipmap.ic_launcher).into(imageFirst)
        else Glide.with(this).load(foto1).into(imageFirst)
    }


}

