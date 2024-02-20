package com.mehedi.beedatesting.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mehedi.beedatesting.R

class AddShoppingFragment : Fragment(R.layout.add_layout_fragment_shopping) {


    private  val viewModel :ShoppingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }




}