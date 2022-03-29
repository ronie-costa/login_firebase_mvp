package com.ronie.loginfirebasemvp.feature.home

import com.ronie.loginfirebasemvp.data.remote.Repository

class HomePresenter : HomeContract.Presenter {

    lateinit var view: HomeContract.View
    private val repository = Repository()

    override fun logout() {
        val successfulCallback = {
            view.logout()
        }
        val failureCallback: (String) -> Unit = { message ->
            view.messageError(message)
        }

        repository.logout(successfulCallback, failureCallback)
    }

    override fun getUser() {
        val successfulCallback: (String) -> Unit = { email ->
            view.startEtEmail(email)
        }
        val failureCallback: (String) -> Unit = { message ->
            view.messageError(message)
        }

        repository.getUser(successfulCallback, failureCallback)
    }

}