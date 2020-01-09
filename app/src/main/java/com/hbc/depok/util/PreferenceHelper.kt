package com.hbc.depok.util

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper (private val context: Context){
    private val ISLOGIN = "islogin"
    private val NAME = "name"
    private val ID = "id"
    private val app_prefs: SharedPreferences

    init {
        app_prefs = context.getSharedPreferences(
                "shared",
                Context.MODE_PRIVATE
        )
    }

    fun putIsLogin(loginorout: Boolean) {
        val edit = app_prefs.edit()
        edit.putBoolean(ISLOGIN, loginorout)
        edit.commit()
    }

    fun getIsLogin(): Boolean {
        return app_prefs.getBoolean(ISLOGIN, false)
    }

    fun putName(loginorout: String) {
        val edit = app_prefs.edit()
        edit.putString(NAME, loginorout)
        edit.commit()
    }

    fun getName(): String? {
        return app_prefs.getString(NAME, "")
    }

    fun putID(loginorout: String) {
        val edit = app_prefs.edit()
        edit.putString(ID, loginorout)
        edit.commit()
    }

    fun getID(): String? {
        return app_prefs.getString(ID, "")
    }
}