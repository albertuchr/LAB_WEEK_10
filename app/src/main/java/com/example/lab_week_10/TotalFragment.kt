package com.example.lab_week_10

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import com.example.lab_week_10.viewmodels.TotalViewModel

class TotalFragment : Fragment() {

    private lateinit var textTotal: TextView
    private lateinit var buttonIncrement: Button

    private val viewModel by lazy {
        ViewModelProvider(requireActivity())[TotalViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_total, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textTotal = view.findViewById(R.id.text_total)
        buttonIncrement = view.findViewById(R.id.button_increment)

        // LiveData Observe Here
        viewModel.total.observe(viewLifecycleOwner, Observer { value ->
            textTotal.text = getString(R.string.text_total, value)
        })

        buttonIncrement.setOnClickListener {
            viewModel.incrementTotal()
        }
    }
}
