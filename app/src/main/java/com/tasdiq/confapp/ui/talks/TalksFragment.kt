package com.tasdiq.confapp.ui.talks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cjp.confapp.model.ConfViewModel
import com.cjp.speaker2.ui.main.SpeakerAdapter
import com.tasdiq.confapp.databinding.FragmentTalksBinding
import com.tasdiq.confapp.ui.speakers.SpeakersFragmentDirections

class TalksFragment : Fragment(), TalkAdapter.TalkClickListener{

    private var _binding: FragmentTalksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: ConfViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(ConfViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTalksBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.listOfTalks
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = TalkAdapter(view.context, this, viewModel)
    }

    override fun listItemClicked(choice: Int) {
        //Show the next set of categories/questions down
        val action = TalksFragmentDirections.actionNavTalksToTalkDetail(choice)
        // Navigate using that action
        this.findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}