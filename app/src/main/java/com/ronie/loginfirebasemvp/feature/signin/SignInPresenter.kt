package com.ronie.loginfirebasemvp.feature.signin

import com.ronie.loginfirebasemvp.data.remote.Repository

class SignInPresenter : SignInContract.Presenter {

    lateinit var view: SignInContract.View
    private val repository = Repository()

    override fun checkEmail(email: String): Boolean {
        if (!email.contains("@") || !email.contains(".")) {
            view.messageError("E-mail incorreto!")
            return true
        }
        return false
    }

    override fun checkPassword(password: String): Boolean {
        if (password.isEmpty() || password.length < 6) {
            view.messageError("Senha incorreta!")
            return true
        }
        return false
    }

    override fun signIn(email: String, password: String) {
        val successfulCallback = {
            view.login()
        }
        val failureCallback: (String) -> Unit = { message ->
            view.messageError(message)
        }

        repository.signIn(email, password, successfulCallback, failureCallback)
    }
}