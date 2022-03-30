package com.ronie.loginfirebasemvp.feature.signup

import com.ronie.loginfirebasemvp.injector.IRepositoryInjector

class SignUpPresenter(
    view: SignUpContract.View,
    injector: IRepositoryInjector
) : SignUpContract.Presenter {

    private val repository = injector.repository()
    private var view: SignUpContract.View? = view

    override fun onDestroy() {
        this.view = null
    }

    override fun checkName(name: String): Boolean {
        return when {
            name.isEmpty() -> {
                view?.messageError("Preencha o campo nome")
                true
            }
            else -> false
        }
    }

    override fun checkEmail(email: String): Boolean {
        return when {
            email.isEmpty() -> {
                view?.messageError("Preencha o campo email")
                true
            }
            !email.contains("@") -> {
                view?.messageError("E-mail incorreto")
                true
            }
            !email.contains(".") -> {
                view?.messageError("E-mail incorreto")
                true
            }
            else -> false
        }
    }

    override fun checkPassword(password: String): Boolean {
        return when {
            password.isEmpty() -> {
                view?.messageError("Preencha o campo senha")
                true
            }
            password.length < 6 -> {
                view?.messageError("Senha precisa conter 6 ou mais caracteres")
                true
            }
            else -> false
        }
    }

    override fun checkConfirmPassword(confirmPassword: String, password: String): Boolean {
        return when {
            confirmPassword.isEmpty() -> {
                view?.messageError("Preencha o campo Confirmar senha")
                true
            }
            confirmPassword != password -> {
                view?.messageError("Senha esta diferente de Confirmar senha, tente novamente.")
                true
            }
            else -> false
        }
    }

    override fun signUp(name: String, email: String, password: String) {
        val successfulCallback: () -> Unit = {
            view?.createUser(email)
        }
        val failureCallback: (String) -> Unit = { message ->
            view?.messageError(message)
        }

        repository.signUp(name, email, password, successfulCallback, failureCallback)
    }
}