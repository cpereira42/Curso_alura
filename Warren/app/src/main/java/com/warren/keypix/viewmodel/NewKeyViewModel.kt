package com.warren.keypix.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewKeyViewModel(val context: Context) : ViewModel() {

    val checkCPF = MutableLiveData<Int>()

    fun teste(){
        checkCPF.value = 1
    }
}