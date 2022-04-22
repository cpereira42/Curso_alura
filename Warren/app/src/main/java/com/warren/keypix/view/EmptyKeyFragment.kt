package com.warren.keypix.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.warren.keypix.R
import kotlinx.android.synthetic.main.fragment_empty_key.*
import kotlinx.android.synthetic.main.fragment_on_boarding.*
import kotlinx.android.synthetic.main.fragment_on_boarding.fragment_on_boarding_continue


class EmptyKeyFragment : Fragment() {

    val action = EmptyKeyFragmentDirections.actionNewKeyFragment()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empty_key, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragment_new_key_button.setOnClickListener {
            Navigation.findNavController(it).navigate(action)
        }
    }

}