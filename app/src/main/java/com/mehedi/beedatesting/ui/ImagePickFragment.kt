package com.mehedi.beedatesting.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.mehedi.beedatesting.R

class ImagePickFragment : Fragment(R.layout.layout_fragment_image_pick) {
    private  val viewModel :ShoppingViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}