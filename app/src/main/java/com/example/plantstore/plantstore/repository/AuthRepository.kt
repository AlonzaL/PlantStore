package com.example.plantstore.plantstore.repository

import android.util.Log
import com.google.firebase.Firebase
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.auth

class AuthRepository {
    private val auth = Firebase.auth
    val user = auth.currentUser

    fun signUp(
        email: String,
        password: String
    ) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Log.d("MyLog", "Sign Up successful")
                } else {
                    Log.d("MyLog", "Sign Up fail")
                }
            }
    }

    fun logIn(
        email: String,
        password: String
    ) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    val user = auth.currentUser
                    Log.d("MyLog", "Log in successful")
                } else {
                    Log.d("MyLog", "Log in fail")
                }
            }
    }

    fun signOut() {
        auth.signOut()
    }

    fun deleteAccount(
        email: String,
        password: String
    ) {
        val credential = EmailAuthProvider.getCredential(email, password)
        auth.currentUser?.reauthenticate(credential)?.addOnCompleteListener {
            if (it.isSuccessful) {
                auth.currentUser?.delete()?.addOnCompleteListener {
                    if (it.isSuccessful) {
                        val user = auth.currentUser
                        Log.d("MyLog", "Delete is successful")
                    } else {
                        Log.d("MyLog", "Delete is fail")
                    }
                }
            }
        }
    }
}