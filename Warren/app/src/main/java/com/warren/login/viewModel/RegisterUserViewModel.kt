package com.warren.login.viewModel

import android.content.Context
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.warren.database.AppDatabase
import com.warren.model.User
import com.warren.utilities.isCPF
import com.warren.utilities.isCnpj
import kotlinx.android.synthetic.main.fragment_register_user.view.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterUserViewModel (val context: Context) : ViewModel() {

    private val _documents = MutableLiveData<String>()
    val documents: LiveData<String>
        get() = _documents



    val checkFields = MutableLiveData<Int>()
    val msgError = MutableLiveData<String>()
    val statusError  = MutableLiveData<Int>()

    private val _username = MutableStateFlow<String>("")
    val username : StateFlow<String> = _username


    private val dao by lazy {
        AppDatabase.instancia(context = context).userDao()
    }

    fun save(newUser: User){
        var error = "OK"
        statusError.value = 0
        if (newUser.doc == null || newUser.doc.length < 11) {
            error = "Documento inválido"
            statusError.value = 1
        }
        if (newUser.name == null || newUser.name.length < 5) {
            error = "Nome inválido"
            statusError.value = 1
        }

        if (newUser.email == null || newUser.email.length < 5) {
            error = "Email inválido"
            statusError.value = 1
        }
        if (newUser.password == null || newUser.password.length < 5) {
            error = "Password inválido"
            statusError.value = 1
        }
        msgError.value = error
        Log.e("Cadastrar MSG","${newUser.password} ")

        if (msgError.value == "OK")
            register(newUser)
    }

    fun register(user: User){
        Log.e("Cadastrar Usuario","campo ${user.doc}")
        viewModelScope.launch {
            try {
                //dao.save(user)
                Log.e("Cadastrar Usuario","Sucesso !!")
            } catch (e: Exception){
                Log.e("Cadastrar Usuario","Falha ao cadastrar")
            }
        }
    }

     fun createUser(view: View) : User{
        val name = view.fragment_register_user_name.text.toString()
        val email = view.fragment_register_user_email.text.toString()
        val password = view.fragment_register_user_password.text.toString()
        val doc = view.fragment_register_user_document.text.toString()
        return User(
            name = name,
            email = email,
            password = password,
            doc = doc)
    }

    fun teste(){
        Log.i("Teste","funcionou")
    }

    fun checkDocuments(s: CharSequence, start: Int, before: Int, count: Int) {
        //Log.w("tag", "Checa CPF $s $start,$before, $count")
        if (start + 1 == 11 && count == 1 && isCPF(s.toString())) {
            Log.w("tag", "Checa CPF $s")
            _documents.value = convertToCPF(s.toString())
        }
        if (start + 1 == 14 && count == 1 && isCnpj(s.toString())){
            Log.w("tag", "Checa CNPJ $s")
            _documents.value=convertToCNPJ(s.toString())
        }
    }

    private fun convertToCPF(number : String): String {
        return number.substring(0,3) + "." + number.substring(3,6) + "." + number.substring(6,9) + "-" + number.substring(9,11)

    }

    private fun convertToCNPJ(number : String): String {
        return number.substring(0,2) + "." + number.substring(2,5) + "." + number.substring(5,8) + "/" + number.substring(8,12) + "-" + number.substring(12,14)
    }

}
