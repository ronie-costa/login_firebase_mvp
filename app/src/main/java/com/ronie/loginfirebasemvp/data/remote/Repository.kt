package com.ronie.loginfirebasemvp.data.remote

interface Repository {
    fun signInRepository(
        email: String,
        password: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    )

    fun signUpRepository(
        email: String,
        password: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    )
}