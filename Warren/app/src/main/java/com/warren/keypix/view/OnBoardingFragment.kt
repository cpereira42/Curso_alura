package com.warren.keypix.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.datastore.dataStore
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.warren.keypix.R
import com.warren.keypix.viewmodel.OnBoardingViewModel
import kotlinx.android.synthetic.main.fragment_on_boarding.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class OnBoardingFragment : Fragment() {

    private val viewModel: OnBoardingViewModel by viewModel()
    val action = OnBoardingFragmentDirections.actionEmptyKeyFragment()
    val action2 = OnBoardingFragmentDirections.actionNewKeyFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observekeys(view)
        viewModel.checkAll()
        fragment_on_boarding_continue.setOnClickListener {
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun observekeys(view: View){
        viewModel.qttKey.observe(viewLifecycleOwner , { qtt : Int ->
            Toast.makeText(context, "Existe  chaves ${qtt.toString()}", Toast.LENGTH_SHORT).show()
            if (qtt > 0)
                view.findNavController().navigate(action2)
        })
    }
}