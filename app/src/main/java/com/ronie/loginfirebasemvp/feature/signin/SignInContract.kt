package com.ronie.loginfirebasemvp.feature.signin

import com.ronie.loginfirebasemvp.base.BasePresenter
import com.ronie.loginfirebasemvp.base.BaseView

interface SignInContract {

    interface Presenter : BasePresenter {
        fun checkEmail(email: String): Boolean
        fun checkPassword(password: String): Boolean
        fun signIn(email: String, password: String)
    }

    interface View:  BaseView<Presenter> {
        fun messageError(message: String)
        fun login()
    }
}