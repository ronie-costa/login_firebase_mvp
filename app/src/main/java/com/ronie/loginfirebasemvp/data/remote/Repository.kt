package com.ronie.loginfirebasemvp.data.remote

import com.google.firebase.auth.FirebaseAuth

class Repository : IRepository {

    private val auth = FirebaseAuth.getInstance()

    override fun signInRepository(
        email: String,
        password: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            isSuccessful()
        }.addOnFailureListener {
            isFailure("Usuario inexistente!")
        }
    }

    override fun signUpRepository(
        email: String,
        password: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            isSuccessful()
        }.addOnFailureListener {
            isFailure("erro ao criar usuario")
        }
    }

}