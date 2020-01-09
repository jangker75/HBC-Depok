package com.hbc.depok.view.ui.listmember

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
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

        viewModel.refresh()

        list.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = memberListAdapter
        }

        refreshLayout.setOnRefreshListener {
            list.visibility = View.GONE
            textStatus.visibility = View.GONE
            loadingView.visibility = View.VISIBLE
//            viewModel.refreshBypassCache()
            viewModel.refresh()
            refreshLayout.isRefreshing = false
        }
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

//        viewModel.setData().observe(this, Observer { t ->
//            t?.data?.let { showData(it) }
//        })
        observeViewModel()
    }


//    private fun showData(data: ArrayList<DataMember>) {
//        list.adapter = ListMemberAdapter(data)
//
//    }

//        list.adapter = ListMemberAdapter()
//
//
//        observeViewModel()


   private fun observeViewModel() {
        viewModel.members.observe(this, Observer { member ->
            member?.let {
                list.visibility = View.VISIBLE
                memberListAdapter.updateMemberList(it)
            }

        })
        viewModel.statusError.observe(this, Observer { Error ->
            Error?.let {
                textStatus.visibility = if (Error) View.VISIBLE else View.GONE
            }
        })
        viewModel.loading.observe(this, Observer { Loading ->
            Loading?.let {
                loadingView.visibility = if (Loading) View.VISIBLE else View.GONE
                if (Loading) {
                    textStatus.visibility = View.GONE
                    list.visibility = View.GONE
                }
            }
        })
    }

}