package com.ronie.loginfirebasemvp.feature.signup

interface SignUpContract {

    interface View {
        fun messageError(message: String)
        fun createUser(email: String)
    }

    interface Presenter {
        fun checkName(name: String): Boolean
        fun checkEmail(email: String): Boolean
        fun checkPassword(password: String): Boolean
        fun checkConfirmPassword(confirmPassword: String, password: String): Boolean
        fun signUp(email: String, password: String)
    }

}