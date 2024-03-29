package com.ronie.loginfirebasemvp.data.remote

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class Repository : IRepository {

    private val auth = FirebaseAuth.getInstance()
    private val firestore = FirebaseFirestore.getInstance()

    override fun signIn(
        email: String,
        password: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    ) {
        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
            isSuccessful()
        }.addOnFailureListener {
            isFailure("Error ao efetuar login, tente novamente!")
        }
    }

    override fun signUp(
        name: String,
        email: String,
        password: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    ) {
        auth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
            val uid = it.user!!.uid
            saveUser(uid, name, email, isSuccessful, isFailure)
        }.addOnFailureListener {
            isFailure("Erro ao criar usuario")
        }
    }

    override fun saveUser(
        uid: String,
        name: String,
        email: String,
        isSuccessful: () -> Unit,
        isFailure: (String) -> Unit
    ) {
        val documentUser = firestore.collection("user").document(uid)

        val mapUser = mapOf(
            "uid" to uid,
            "name" to name,
            "email" to email
        )

        documentUser.set(mapUser).addOnSuccessListener {
            isSuccessful()
        }.addOnFailureListener {
            isFailure("Erro ao criar usuário")
        }
    }

    override fun getUser(isSuccessful: (String) -> Unit, isFailure: (String) -> Unit) {
        if (auth.currentUser != null) {
            val email = auth.currentUser!!.email.toString()
            isSuccessful(email)
        } else {
            isFailure("Erro ao buscar dados do usuário")
        }
    }

    override fun logout(isSuccessful: () -> Unit, isFailure: (String) -> Unit) {
        if (auth.currentUser != null) {
            auth.signOut()
            isSuccessful()
        } else {
            isFailure("Erro ao deslogar usuário!")
        }
    }

}