package com.warren.di

import com.warren.login.viewModel.RegisterUserViewModel
import com.warren.keypix.viewmodel.NewKeyViewModel
import com.warren.keypix.viewmodel.OnBoardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel{
        OnBoardingViewModel(get())
    }
    viewModel {
        NewKeyViewModel(get())
    }
    viewModel {
        RegisterUserViewModel(get())
    }
}