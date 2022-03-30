package com.ronie.loginfirebasemvp.feature.signin

import com.ronie.loginfirebasemvp.injector.IRepositoryInjector

class SignInPresenter(
    view: SignInContract.View,
    injector: IRepositoryInjector
) : SignInContract.Presenter {

    private var repository = injector.repository()
    private var view: SignInContract.View? = view

    override fun onDestroy() {
        this.view = null
    }

    override fun checkEmail(email: String): Boolean {
        if (!email.contains("@") || !email.contains(".")) {
            view?.messageError("E-mail incorreto!")
            return true
        }
        return false
    }

    override fun checkPassword(password: String): Boolean {
        if (password.isEmpty() || password.length < 6) {
            view?.messageError("Senha incorreta!")
            return true
        }
        return false
    }

    override fun signIn(email: String, password: String) {
        val successfulCallback: () -> Unit = {
            view?.login()
        }
        val failureCallback: (String) -> Unit = { message ->
            view?.messageError(message)
        }

        repository.signIn(email, password, successfulCallback, failureCallback)
    }
}