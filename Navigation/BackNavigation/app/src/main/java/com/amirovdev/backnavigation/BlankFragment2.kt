package com.amirovdev.backnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_blank2.*

class BlankFragment2 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank2, container, false)
    }

    // set BlankFragment1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_activity2_fragment2.setOnClickListener {
            activity?.supportFragmentManager
                ?.beginTransaction()
                ?.add(R.id.container_activity2, BlankFragment1())
                ?.addToBackStack(null)
                ?.commit()
        }
    }
}