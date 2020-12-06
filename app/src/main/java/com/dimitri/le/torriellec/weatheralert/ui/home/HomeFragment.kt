package com.dimitri.le.torriellec.weatheralert.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.dimitri.le.torriellec.weatheralert.R
import com.dimitri.le.torriellec.weatheralert.ui.view.adapter.CitiesAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()


    private val onProgramClicked: (city: String) -> Unit =
        { city ->
            val bundle = bundleOf(
                "city" to city
            )
            view.let {
                it?.let { it1 ->
                    Navigation.findNavController(it1)
                        .navigate(R.id.action_HomeFragment_to_WeaherFragment, bundle)
                }
            }
        }

    private val recyclerAdapter = CitiesAdapter(onProgramClicked)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cities_recycler.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = recyclerAdapter
        }

        viewModel.uiData.observe(viewLifecycleOwner, Observer { cities ->
            recyclerAdapter.submitList(cities)
        })

        view.findViewById<Button>(R.id.button_favourite).setOnClickListener {
            viewModel.saveCity(editview_city.text.toString())
        }
    }
}