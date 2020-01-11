package com.hbc.depok.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import android.view.ContextMenu
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.hbc.depok.R
import com.hbc.depok.model.LoginUser
import com.hbc.depok.network.ApiService
import com.hbc.depok.view.ui.login.LoginClickListener
import com.hbc.depok.view.ui.login.LoginFragmentDirections
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.login_fragment.*


class LoginViewModel(application: Application) : BaseViewModel(application) {
    val TAG = "LoginViewModel"
    var email: ObservableField<String>? = null
    var password: ObservableField<String>? = null
    val loadingLogin = MutableLiveData<Boolean>()
    var login = MutableLiveData<LoginUser>()
    private val disposable = CompositeDisposable()
    val apiService by lazy {
        ApiService.api
    }

    init {
        loadingLogin.value = false
//        fetchDataLoginFromRemote()
        email = ObservableField("")
        password = ObservableField("")
    }
fun registerOnClicked(v:View){
        findNavController(v).navigate(LoginFragmentDirections.actionRegisterFragment())
}
    fun loginOnClicked() {
        loadingLogin.value = true
        disposable.add(
            apiService.login(email?.get()!!, password?.get()!!)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.computation())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { result ->
                        login.value = result
                        Log.d(
                            TAG,
                            "Data Login : username=${email?.get()!!}, password=${password?.get()!!}"
                        )
                        Log.d(TAG, "Data Result $result")
                        loadingLogin.value = false
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
                        Toast.makeText(getApplication(), "Error Network", Toast.LENGTH_SHORT).show()
                        e.printStackTrace()
                    }
                )
        )
    }
}
