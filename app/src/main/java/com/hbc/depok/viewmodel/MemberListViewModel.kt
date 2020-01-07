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
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MemberListViewModel(application: Application) : BaseViewModel(application) {
    //    private var data = MutableLiveData<Member>()

    private val disposable = CompositeDisposable()
    // private val apiService: ApiService? = null
    private val TAG = "MemberListViewModel"
    val apiService by lazy {
        ApiService.api
    }
    var members = MutableLiveData<List<DataMember>>()
    var statusError = MutableLiveData<Boolean>()

    val loading = MutableLiveData<Boolean>()

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
//    private fun fetchDataFromRemote() {
//        loading.value = true
//        disposable.add(
//                apiService.getDaftarMember()
//                        .subscribeOn(Schedulers.io())
//                        .unsubscribeOn(Schedulers.computation())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe(
//                                { result ->
//                                    members.value = result.data
//                                    loading.value = false
//                                    Log.d(TAG, "FetchDataFromRemote : data is ${result.data}")
//                                },
//                                { e ->
//                                    statusError.value = true
//                                    loading.value = false
//                                    e.printStackTrace()
//                                    Log.d("FetchDataFromRemote :", "tidak bisa statusError: ${statusError.value} loading : ${loading.value}")
//                                }
//                        )
//        )
//    }

    private fun fetchDataFromRemote() {
        loading.value = true
        disposable.add(
                apiService.getDaftarMemberChapter("2")
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result ->
                                    members.value = result.data
                                    loading.value = false
                                    Log.d(TAG, "FetchDataFromRemote : data is ${result.data}")
                                },
                                { e ->
                                    statusError.value = true
                                    loading.value = false
                                    e.printStackTrace()
                                    Log.d("FetchDataFromRemote :", "tidak bisa statusError: ${statusError.value} loading : ${loading.value}")
                                }
                        )
        )
    }

//    fun setData(): MutableLiveData<List<DataMember>> {
//        return
//    }

//    fun getStatus(): MutableLiveData<Boolean> {
//        statusError.value = true
//        return statusError
//    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

    fun refresh() {
        fetchDataFromRemote()
    }
}

