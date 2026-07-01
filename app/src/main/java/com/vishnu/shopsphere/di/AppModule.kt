package com.vishnu.shopsphere.di

import com.google.firebase.auth.FirebaseAuth
import com.vishnu.shopsphere.auth.AuthViewModel
import com.vishnu.shopsphere.repository.AuthRepository
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    // Firebase Authentication
    single {
        FirebaseAuth.getInstance()
    }

    // Repository
    single {
        AuthRepository(get())
    }

    // ViewModel
    viewModel {
        AuthViewModel(get())
    }
}