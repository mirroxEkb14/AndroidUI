package com.amirovdev.navigationlibraryactions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import timber.log.Timber

class ThreeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        // to see our passed data in logs (implementation "com.jakewharton.timber:timber:4.7.1")
        Timber.d(arguments.toString())

        // Bundle[{arg1=Hello!}]
        println("\n--------------------------------\n${arguments.toString()}\n---------------------------------------\n")

        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.btn_next3).setOnClickListener {
            Toast.makeText(requireContext(), "No more fragments", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<Button>(R.id.btn_previous3).setOnClickListener {
            (activity as MainActivity).navController.popBackStack()
        }
    }
}