package com.tasdiq.confapp.ui.talks

import android.content.res.Resources
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.tasdiq.confapp.model.ConfViewModel
import com.tasdiq.confapp.databinding.FragmentTalkDetailBinding


class TalkDetail : Fragment() {

    companion object {
        fun newInstance() = TalkDetail()
    }

    private lateinit var viewModel: ConfViewModel
    private var talkListIndex : Int = 0
    private var _binding: FragmentTalkDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModelProvider = ViewModelProvider(requireActivity())
        viewModel = viewModelProvider[ConfViewModel::class.java]

        arguments?.let {
            talkListIndex = it.getInt("talkListIndex")
        }
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentTalkDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val talk = viewModel.allTalks[talkListIndex]
        binding.talkTitle.text = talk.title
        binding.speakerButton.text = viewModel.speakerNameFromSpeakerId(talk.speakerId)
        binding.talkDescription.text = talk.content
        val location = viewModel.locationNameFromLocationId(talk.locationId)
        binding.locationButton.text = "Location: $location"
        val speakerIndex = viewModel.speakerIndexFromSpeakerId(talk.speakerId)
        binding.speakerButton.setOnClickListener{clickListener(speakerIndex)}
    }

    private fun clickListener(choice: Int) {
        val action = TalkDetailDirections.actionTalkDetailToSpeakerDetail(choice)
        // Navigate using that action
        this.findNavController().navigate(action)
    }


}