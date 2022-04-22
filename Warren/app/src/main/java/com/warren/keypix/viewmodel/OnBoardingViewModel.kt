package com.warren.keypix.viewmodel
import android.content.Context
import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.warren.keypix.preferences.dataStore
import com.warren.keypix.preferences.qttKeys
import com.warren.keypix.preferences.usuarioNotificado
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch


class OnBoardingViewModel(val context: Context) : ViewModel() {

    val qttKey = MutableLiveData<Int>()

    fun checkAll(){
        Log.i("Notifica", "Inicio")
        viewModelScope.launch {
            removeKey()
            saveKey()
            checkkeys()
        }
    }

    suspend fun checkkeys(){
        var dsQttKeys =  context.dataStore.data.first()[qttKeys]
        if (dsQttKeys != null)
        {
            Log.i("Keys", " > 0")
            qttKey.value = dsQttKeys.toInt()
        }
        else
        {
            qttKey.value = 0
            Log.i("Keys", "0")
        }

    }

    suspend fun saveNotification(){
        context.dataStore.edit { preferences ->
            preferences[usuarioNotificado] = "Sim" }
        Log.i("Notifica", "Logando")
    }

    suspend fun deslogar(){
        Log.i("Notifica", "Deslogando")
        context.dataStore.edit { preferences ->
            preferences.remove(usuarioNotificado)
        }
    }

    suspend fun saveKey(){
        context.dataStore.edit { preferences ->
            preferences[qttKeys] = "1" }
        Log.i("Notifica", "qttKeys")
    }

    suspend fun removeKey(){
        Log.i("Notifica", "Deslogando")
        context.dataStore.edit { preferences ->
            preferences.remove(qttKeys)
        }
    }
}