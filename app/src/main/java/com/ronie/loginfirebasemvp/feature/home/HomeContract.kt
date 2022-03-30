package com.ronie.loginfirebasemvp.feature.home

import com.ronie.loginfirebasemvp.base.BasePresenter
import com.ronie.loginfirebasemvp.base.BaseView

interface HomeContract {

    interface Presenter : BasePresenter {
        fun logout()
        fun getUser()
    }

    interface View : BaseView<Presenter> {
        fun startEtEmail(email: String)
        fun messageError(message: String)
        fun logout()
    }

}