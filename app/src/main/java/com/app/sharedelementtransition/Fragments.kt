package com.app.sharedelementtransition

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController

class FragmentOne : Fragment(R.layout.fragment_one) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.findViewById<ImageView>(R.id.small_image)?.setOnClickListener {
            val extras = FragmentNavigatorExtras(it to "second_fragment")
            findNavController().navigate(
                R.id.action_fragmentOne_to_fragmentTwo,
                null,
                null,
                extras
            )
        }
    }
}

class FragmentTwo : Fragment(R.layout.fragment_two) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animation = TransitionInflater.from(requireContext()).inflateTransition(
            android.R.transition.move
        )
        sharedElementEnterTransition = animation
        sharedElementReturnTransition = animation
    }

}