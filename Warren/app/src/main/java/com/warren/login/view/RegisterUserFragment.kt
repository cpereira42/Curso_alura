package com.warren.login.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.warren.login.viewModel.RegisterUserViewModel
import com.warren.keypix.R
import com.warren.keypix.databinding.FragmentRegisterUserBinding
import com.warren.keypix.viewmodel.OnBoardingViewModel
import com.warren.model.User
import kotlinx.android.synthetic.main.fragment_register_user.*
import kotlinx.coroutines.delay
import org.koin.androidx.viewmodel.ext.android.viewModel

class RegisterUserFragment : Fragment() {

    private lateinit var dataBinding: FragmentRegisterUserBinding

    private val viewModel: RegisterUserViewModel by viewModel()




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_register_user, container, false)
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_register_user,
            container,
            false
        )
        //viewModel = ViewModelProvider(this).get(RegisterUserViewModel::class.java)

        dataBinding.viewModel = viewModel
        dataBinding.lifecycleOwner = viewLifecycleOwner

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_login, container, false)
        return(dataBinding.root)
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeCheck()
        clickButton(view)
        observeError()
        viewModel.checkFields.value = 1
    }


    fun observeCheck(){
        viewModel.checkFields.observe(viewLifecycleOwner , { check : Int ->
            fragment_register_user_continue.isEnabled = check == 1
        })
    }

    fun observeError(){
        viewModel.msgError.observe(viewLifecycleOwner , { msg : String ->
            Log.e("msg", "${msg}")
        })
    }

    fun clickButton(view: View){
        fragment_register_user_continue.setOnClickListener {
            val newUser = viewModel.createUser(view)
            Log.e("Salvando", "Salvando")
            viewModel.save(newUser)
        }
    }

    /*private fun createUser() : User{
        val name = fragment_register_user_name.text.toString()
        val email = fragment_register_user_email.text.toString()
        val password = fragment_register_user_password.text.toString()
        val doc = fragment_register_user_document.text.toString()
        return User(
            name = name,
            email = email,
            password = password,
            doc = doc)
    }*/


}