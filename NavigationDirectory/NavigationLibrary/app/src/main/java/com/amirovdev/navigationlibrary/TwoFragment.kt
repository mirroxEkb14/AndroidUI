package com.amirovdev.navigationlibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class TwoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // from Fragment2 switch to Fragment3
        view.findViewById<Button>(R.id.btn_next2).setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.threeFragment) // name from navigation.xml
        }

        // from Fragment2 switch to Fragment1
        view.findViewById<Button>(R.id.btn_previous2).setOnClickListener {
            (activity as MainActivity).navController.popBackStack()
        }
    }
}