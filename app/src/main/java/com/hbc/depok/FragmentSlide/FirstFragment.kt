package com.hbc.depok.FragmentSlide


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hbc.depok.R

class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val foto1 = this.arguments?.getString("IMAGE1")
        val foto2 = this.arguments?.getBundle("IMAGE1")
        println("FOTO 1 di fragment = " +foto1)
        println("FOTO 1-1 di fragment = " +foto2)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_first, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        if (foto2 == null)
//            Glide.with(this).load(R.mipmap.ic_launcher).into(imageFirst)
//        else Glide.with(this).load(foto2).into(imageFirst)

    }


}


