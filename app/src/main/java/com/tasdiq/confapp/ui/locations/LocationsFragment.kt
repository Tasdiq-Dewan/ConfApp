package com.tasdiq.confapp.ui.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tasdiq.confapp.model.ConfViewModel
import com.cjp.speaker2.ui.main.SpeakerAdapter
import com.tasdiq.confapp.databinding.FragmentLocationsBinding
import com.tasdiq.confapp.ui.speakers.SpeakersFragment
import com.tasdiq.confapp.ui.speakers.SpeakersFragmentDirections

class LocationsFragment : Fragment(), LocationAdapter.LocationClickListener {

    private var _binding: FragmentLocationsBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModel: ConfViewModel
    private lateinit var recyclerView: RecyclerView

    companion object {
        fun newInstance() = LocationsFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ConfViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.listOfLocations
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = LocationAdapter(view.context, this, viewModel)
    }

    override fun listItemClicked(choice: Int) {
        //Show the next set of categories/questions down
        val action = LocationsFragmentDirections.actionNavLocationsToLocationMap()
        // Navigate using that action
        this.findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}