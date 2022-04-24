package com.amirovdev.navigationlibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class OneFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // from Fragment1 switch to Fragment2
        view.findViewById<Button>(R.id.btn_next1).setOnClickListener {
            (activity as MainActivity).navController.navigate(R.id.twoFragment) // name from navigation.xml
        }

        // from Fragment1 nothing to show if we go back
        view.findViewById<Button>(R.id.btn_previous1).setOnClickListener {
            Toast.makeText(requireContext(), "No more fragments", Toast.LENGTH_SHORT).show()
        }
    }
}