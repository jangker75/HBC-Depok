package com.hbc.depok.FragmentSlide


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hbc.depok.DetailMemberActivity
import com.hbc.depok.GlideApp

import com.hbc.depok.R
import kotlinx.android.synthetic.main.fragment_first.*

class SecondFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

  return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val foto2 = arguments?.getString("IMAGE2")
        println("FOTO 2 di fragment = " +foto2)
        if(foto2 == null)
            GlideApp.with(this).load(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(imageFirst)
        else GlideApp.with(this).load(foto2).placeholder(R.mipmap.ic_launcher).into(imageFirst)
    }
}
