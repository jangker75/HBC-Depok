package com.hbc.depok.viewmodel

import android.app.Application
import android.provider.ContactsContract
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.hbc.depok.adapter.ListMemberAdapter
import com.hbc.depok.model.DataMember
import com.hbc.depok.model.Member
import com.hbc.depok.network.Api

import com.hbc.depok.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MemberListViewModel(application: Application) : BaseViewModel(application) {
    //    private var data = MutableLiveData<Member>()
    private var status = MutableLiveData<Boolean>()
    private val disposable = CompositeDisposable()
    private val apiService: ApiService? = null
    private val memberListAdapter = ListMemberAdapter()
    //    private val dataMembers: MutableList<DataMember> = mutableListOf()
    val members = MutableLiveData<List<Member>>()
    val membersLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

//    init {
//        getData()
//    }
init {
    fetchDataFromRemote()
}

    //    private fun getData() {
//
//        status.value = true
//
//        NetworkConfig().api().getDaftarMember().enqueue(object : Callback<Member> {
//            override fun onFailure(call: Call<Member>, t: Throwable) {
//                status.value = true
//                members.value = null
//            }
//
//            override fun onResponse(call: Call<List<DataMember>>, response: Response<List<DataMember>>) {
//                status.value = false
//
//                if (response.isSuccessful) {
//                    members.value = response.body()
//                } else {
//                    status.value = true
//                }
//            }
//        })
//    }

    //    fun fetchDataFromRemote() {
//        loading.value = true
//        disposable.add(
//                apiService.getMember()
//                        .subscribeOn(Schedulers.newThread())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribeWith(object : DisposableSingleObserver<List<Member>>() {
//                            override fun onSuccess(memberList: List<Member>) {
////                                storeDogsLocally(dogList)
//                               dataMembers.
//                                Toast.makeText(getApplication(), "Dogs Retrieved from endpoint", Toast.LENGTH_SHORT).show()
//                            }
//
//                            override fun onError(e: Throwable) {
//                                membersLoadError.value = true
//                                loading.value = false
//                                e.printStackTrace()
//                            }
//                        })
//        )
//    }
    private fun fetchDataFromRemote() {
//        loading.value = true
        disposable.add(
                apiService!!.retrofit.getDaftarMember()
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {
                                    memberListAdapter.updateMemberList(it.data)
                                },
                                { Log.d("FetchDataFromRemote :", "tidak bisa") }
                        )
        )
    }

//    fun setData(): MutableLiveData<List<DataMember>> {
//        return
//    }

    fun getStatus(): MutableLiveData<Boolean> {
        status.value = true
        return status
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}

