package com.warren.keypix.view

import android.animation.Animator
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.warren.keypix.R
import com.warren.keypix.viewmodel.NewKeyViewModel
import com.warren.keypix.viewmodel.OnBoardingViewModel
import kotlinx.android.synthetic.main.fragment_new_key.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewKeyFragment : Fragment() {

    private val viewModel: NewKeyViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_key, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        actions()
        //fragment_new_key_card1.visibility = View.GONE
    }

    fun actions(){
        fragment_new_key_card1.setOnClickListener {
            resetColor()
            fragment_new_key_check1.visibility = View.VISIBLE
            fragment_new_key_card1.setCardBackgroundColor(Color.parseColor("#fdeef2"))
        }
        fragment_new_key_card2.setOnClickListener {
            resetColor()
            fragment_new_key_check2.visibility = View.VISIBLE
            fragment_new_key_card2.setCardBackgroundColor(Color.parseColor("#fdeef2"))
        }
        fragment_new_key_card3.setOnClickListener {
            resetColor()
            fragment_new_key_check3.visibility = View.VISIBLE
            fragment_new_key_card3.setCardBackgroundColor(Color.parseColor("#fdeef2"))
        }
        fragment_new_key_card4.setOnClickListener {
            resetColor()
            fragment_new_key_check4.visibility = View.VISIBLE
            fragment_new_key_card4.setCardBackgroundColor(Color.parseColor("#fdeef2"))
        }
    }

    fun resetColor(){
        fragment_new_key_card1.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        fragment_new_key_card2.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        fragment_new_key_card3.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        fragment_new_key_card4.setCardBackgroundColor(Color.parseColor("#FFFFFF"))
        fragment_new_key_check1.visibility = View.GONE
        fragment_new_key_check2.visibility = View.GONE
        fragment_new_key_check3.visibility = View.GONE
        fragment_new_key_check4.visibility = View.GONE
    }
}