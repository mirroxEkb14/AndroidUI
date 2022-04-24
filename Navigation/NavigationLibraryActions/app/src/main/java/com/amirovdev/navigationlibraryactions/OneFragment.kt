package com.amirovdev.navigationlibraryactions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.amirovdev.navigationlibraryactions.R

class OneFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*
          Instead of passing Fragment id we can pass Action id, to create it:
          in navigation.xml select a Fragment, click on the arrow above:
          Destination: to what Fragment to go
                after it an ID will appear that we can paste in 'navigate' method instead of Fragment id
          Transition block: animation when the Fragments are changed
          Pop to: we set the OneFragment to switch to ThreeFragment and ThreeFragment to switch to OneFragment,
                in ThreeFragment in 'Pop to' section set 'OneFragment', now after clicking on back button from
                ThreeFragment we go to OneFragment
          Inclusive: if we set it, in stack we have only one OneFragment, if not - two OneFragments

          It is recommended to switch between Fragments with Actions
         */
        view.findViewById<Button>(R.id.btn_next1).setOnClickListener {
            // pass the data in a classical way
            val bundle = Bundle()
            bundle.putString("arg1", "Hello!") // 'arg1' is a key

            // now pass the bundle as the second argument
            (activity as MainActivity).navController.navigate(R.id.action_oneFragment_to_threeFragment, bundle) // id Action from navigation.xml

            // go to ThreeFragment
        }

        view.findViewById<Button>(R.id.btn_previous1).setOnClickListener {
            Toast.makeText(requireContext(), "No more fragments", Toast.LENGTH_SHORT).show()
        }
    }
}