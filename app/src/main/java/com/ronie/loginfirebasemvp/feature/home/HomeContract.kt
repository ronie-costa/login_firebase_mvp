package com.ronie.loginfirebasemvp.feature.home

interface HomeContract {
    interface View {
        fun startEtEmail(email: String)
        fun messageError(message: String)
        fun logout()
    }
    interface Presenter {
        fun logout()
        fun getUser()
    }
}