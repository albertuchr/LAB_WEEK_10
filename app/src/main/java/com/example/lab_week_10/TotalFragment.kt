package com.example.lab_week_10

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class TotalFragment : Fragment() {

    private lateinit var textTotal: TextView
    private lateinit var buttonIncrement: Button
    private var total = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_total, container, false)

        textTotal = view.findViewById(R.id.text_total)
        buttonIncrement = view.findViewById(R.id.button_increment)

        buttonIncrement.setOnClickListener {
            total++
            textTotal.text = getString(R.string.text_total, total)
        }

        return view
    }
}
