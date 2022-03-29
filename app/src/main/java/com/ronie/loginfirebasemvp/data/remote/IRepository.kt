package com.ronie.loginfirebasemvp.data.remote

interface IRepository {

    fun signInRepository(
        email: String,
        password: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    )

    fun signUpRepository(
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

}