package com.ronie.loginfirebasemvp.data.remote

interface IRepository {

    fun signIn(
        email: String,
        password: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    )

    fun signUp(
        name: String,
        email: String,
        password: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    )

    fun saveUser(
        uid: String,
        name: String,
        email: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    )

    fun getUser(isSuccessful: (String) -> Unit, isFailure: (String) -> Unit)

    fun logout(isSuccessful: () -> Unit, isFailure: (String) -> Unit)

}