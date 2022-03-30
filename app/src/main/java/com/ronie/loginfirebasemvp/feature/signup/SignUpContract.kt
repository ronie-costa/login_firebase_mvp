package com.ronie.loginfirebasemvp.feature.signup

import com.ronie.loginfirebasemvp.base.BasePresenter
import com.ronie.loginfirebasemvp.base.BaseView

interface SignUpContract {

    interface Presenter : BasePresenter {
        fun checkName(name: String): Boolean
        fun checkEmail(email: String): Boolean
        fun checkPassword(password: String): Boolean
        fun checkConfirmPassword(confirmPassword: String, password: String): Boolean
        fun signUp(name: String, email: String, password: String)
    }

    interface View : BaseView<Presenter> {
        fun messageError(message: String)
        fun createUser(email: String)
    }

}