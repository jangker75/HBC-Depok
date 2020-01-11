package com.hbc.depok.view.ui.pengurus

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hbc.depok.viewmodel.PengurusViewModel
import com.hbc.depok.R


class PengurusFragment : Fragment() {

    companion object {
        fun newInstance() = PengurusFragment()
    }

    private lateinit var viewModel: PengurusViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.pengurus_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PengurusViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
