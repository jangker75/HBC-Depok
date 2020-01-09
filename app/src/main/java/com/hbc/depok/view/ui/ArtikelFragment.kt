package com.hbc.depok.view.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hbc.depok.viewmodel.ArtikelViewModel
import com.hbc.depok.R


class ArtikelFragment : Fragment() {

    companion object {
        fun newInstance() = ArtikelFragment()
    }

    private lateinit var viewModel: ArtikelViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.artikel_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ArtikelViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
