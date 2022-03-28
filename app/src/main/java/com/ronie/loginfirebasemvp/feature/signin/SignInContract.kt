package com.ronie.loginfirebasemvp.feature.signin

interface SignInContract {
    interface View {
        fun messageError(message: String)
        fun login()
    }
    interface Presenter {
        fun checkEmail(email: String): Boolean
        fun checkPassword(password: String): Boolean
        fun signIn(email: String, password: String)
    }
}