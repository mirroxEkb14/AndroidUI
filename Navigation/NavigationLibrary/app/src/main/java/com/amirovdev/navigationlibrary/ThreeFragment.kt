package com.amirovdev.navigationlibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast

class ThreeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // from Fragment3 nothing to show if we go forward
        view.findViewById<Button>(R.id.btn_next3).setOnClickListener {
            Toast.makeText(requireContext(), "No more fragments", Toast.LENGTH_SHORT).show()
        }

        // from Fragment3 swtich to Fragment2
        view.findViewById<Button>(R.id.btn_previous3).setOnClickListener {
            (activity as MainActivity).navController.popBackStack()
        }
    }
}