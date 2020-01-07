package com.hbc.depok.viewmodel

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hbc.depok.model.DataMember
import com.hbc.depok.model.LoginUser
import com.hbc.depok.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel(application: Application) : BaseViewModel(application) {

    private val disposable = CompositeDisposable()
    val apiService by lazy {
        ApiService.api
    }
    var login = MutableLiveData<LoginUser>()

    private fun fetchDataLoginFromRemote() {
        disposable.add(
                apiService.login("003", "1718")
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result ->
                                    login.value = result.

                                },
                                { e ->
                                    Toast.makeText(getApplication(), "Rusak", Toast.LENGTH_SHORT)
                                    e.printStackTrace()

                                }
                        )
        )
    }

    override fun onCleared() {
        super.onCleared()
    }
}
