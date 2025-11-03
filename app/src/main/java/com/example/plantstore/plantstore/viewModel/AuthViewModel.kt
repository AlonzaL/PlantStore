package com.example.plantstore.plantstore.viewModel

import androidx.lifecycle.ViewModel
import com.example.plantstore.plantstore.repository.AuthRepository

class AuthViewModel: ViewModel() {
    private val repository = AuthRepository()

    fun signUp(email: String, password: String){
        return repository.signUp(email, password)
    }

    fun logIn(email: String, password: String){
        return repository.logIn(email, password)
    }

    fun signOut() {
        return repository.signOut()
    }

    fun deleteAccount(email: String, password: String){
        return repository.deleteAccount(email, password)
    }
}