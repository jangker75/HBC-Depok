package com.hbc.depok.viewmodel

import android.app.Application
import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.hbc.depok.model.LoginUser
import com.hbc.depok.network.ApiService
import com.hbc.depok.util.isEmailValid
import com.hbc.depok.view.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel(application: Application) : BaseViewModel(application) {
    val TAG = "LoginViewModel"
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    var btnSelected: ObservableBoolean? = null
    val loadingLogin = MutableLiveData<Boolean>()
    private val disposable = CompositeDisposable()
    val apiService by lazy {
        ApiService.api
    }
    val intent = Intent(application, MainActivity::class.java)
    var login = MutableLiveData<LoginUser>()

    init {
        loadingLogin.value = false
        btnSelected = ObservableBoolean(false)
//        fetchDataLoginFromRemote()
        email = ObservableField("")
        password = ObservableField("")
    }

    fun onEmailChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(isEmailValid(s.toString()) && password?.get()!!.length >= 8)


    }

    fun onPasswordChanged(s: CharSequence, start: Int, befor: Int, count: Int) {
        btnSelected?.set(isEmailValid(email?.get()!!) && s.toString().length >= 8)


    }

    fun loginClicked() {
        loadingLogin.value = true
        disposable.add(
                apiService.login(email?.get()!!, password?.get()!!)
                        .subscribeOn(Schedulers.io())
                        .unsubscribeOn(Schedulers.computation())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { result ->
                                    login.value = result
                                    Log.d(TAG, "Data Login : username=${email?.get()!!}, password=${password?.get()!!}")
                                    Log.d(TAG, "Data Result $result")
                                    loadingLogin.value=false
//                                        if (it.value?.apiMessage == "Login Berhasil") {
//                                            it
//                                            loadingLogin.value=false
//                                           // intent
//                                        }else{
//                                            it
//                                            loadingLogin.value=false
//                                        }


                                },
                                { e ->
                                    loadingLogin.value = false
                                    Toast.makeText(getApplication(), "Error Network", Toast.LENGTH_SHORT)
                                    e.printStackTrace()

                                }
                        )
        )
    }
}
