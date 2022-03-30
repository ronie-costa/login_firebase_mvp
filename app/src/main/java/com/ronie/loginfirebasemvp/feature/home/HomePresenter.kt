package com.ronie.loginfirebasemvp.feature.home

import com.ronie.loginfirebasemvp.injector.IRepositoryInjector

class HomePresenter(
    view: HomeContract.View,
    injector: IRepositoryInjector
) : HomeContract.Presenter {

    private val repository = injector.repository()
    private var view: HomeContract.View? = view

    override fun onDestroy() {
        this.view = null
    }

    override fun logout() {
        val successfulCallback: () -> Unit = {
            view?.logout()
        }
        val failureCallback: (String) -> Unit = { message ->
            view?.messageError(message)
        }

        repository.logout(successfulCallback, failureCallback)
    }

    override fun getUser() {
        val successfulCallback: (String) -> Unit = { email ->
            view?.startEtEmail(email)
        }
        val failureCallback: (String) -> Unit = { message ->
            view?.messageError(message)
        }

        repository.getUser(successfulCallback, failureCallback)
    }
}