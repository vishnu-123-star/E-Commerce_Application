package com.vishnu.shopsphere.auth

import androidx.lifecycle.ViewModel
import com.vishnu.shopsphere.repository.AuthRepository

class AuthViewModel : ViewModel() {

    private val repository = AuthRepository()

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {

        repository.login(
            email,
            password,
            onSuccess,
            onFailure
        )
    }

    fun register(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit
    ) {

        repository.register(
            email,
            password,
            onSuccess,
            onFailure
        )
    }
}