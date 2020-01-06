package com.hbc.depok.view.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.hbc.depok.viewmodel.MemberListViewModel
import com.hbc.depok.R
import com.hbc.depok.adapter.ListMemberAdapter
import kotlinx.android.synthetic.main.member_fragment.*


class MemberListFragment : Fragment() {
    private lateinit var viewModel: MemberListViewModel
    private val memberListAdapter = ListMemberAdapter()

    companion object {
        fun newInstance() = MemberListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.member_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MemberListViewModel::class.java)

//        viewModel.getStatus().observe(this, Observer { t ->
//            if (t ?: true) {
//                list.visibility = View.GONE
//                textStatus.visibility = View.VISIBLE
//            } else {
//                list.visibility = View.VISIBLE
//                textStatus.visibility = View.GONE
//            }
//
//        })
//
//        viewModel.setData().observe(this, Observer { t ->
//            t?.data?.let { showData(it) }
//        })
//    }


//    private fun showData(data: ArrayList<DataMember>) {
//        list.adapter = ListMemberAdapter(data)
//
//    }

        list.adapter = ListMemberAdapter()


        observeViewModel()

    }

    fun observeViewModel() {
        viewModel.members.observe(this, Observer { member ->
            member?.let {
                list.visibility = View.VISIBLE

//                memberListAdapter.updateMemberList(it)
            }

        })
        viewModel.membersLoadError.observe(this, Observer { isError ->
            isError?.let {
                textStatus.visibility = if (isError) View.VISIBLE else View.GONE
            }
        })
        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loadingView.visibility = if (isLoading) View.VISIBLE else View.GONE
                if (isLoading) {
                    textStatus.visibility = View.GONE
                    list.visibility = View.GONE
                }
            }
        })
    }

}