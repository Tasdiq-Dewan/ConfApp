package com.tasdiq.confapp.ui.speakers

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
import com.tasdiq.confapp.databinding.FragmentSpeakersBinding

class SpeakersFragment : Fragment(), SpeakerAdapter.SpeakerClickListener {

    companion object {
        fun newInstance() = SpeakersFragment()
    }

    private lateinit var viewModel: ConfViewModel
    private lateinit var recyclerView: RecyclerView

    private var _binding: FragmentSpeakersBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ConfViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSpeakersBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.listOfSpeakers
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = SpeakerAdapter(view.context, this, viewModel)
    }

    override fun listItemClicked(choice: Int) {
        //Show the next set of categories/questions down
        val action = SpeakersFragmentDirections.actionNavSpeakersToSpeakerDetail(choice)
        // Navigate using that action
        this.findNavController().navigate(action)
    }
}