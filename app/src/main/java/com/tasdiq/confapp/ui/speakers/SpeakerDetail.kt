package com.cjp.speaker2.ui.main

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.cjp.confapp.model.ConfViewModel
import com.tasdiq.confapp.databinding.FragmentSpeakerDetailBinding


class SpeakerDetail : Fragment() {

    private var speakerListIndex = 0

    companion object {
        fun newInstance() = SpeakerDetail()
    }

    private lateinit var viewModel: ConfViewModel

    private var _binding: FragmentSpeakerDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val viewModelProvider = ViewModelProvider(requireActivity())
        viewModel = viewModelProvider[ConfViewModel::class.java]

        arguments?.let {
            speakerListIndex = it.getInt("speakerListIndex")
        }

        // Retrieve and inflate the layout for this fragment
        _binding = FragmentSpeakerDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val speaker = viewModel.allSpeakers[speakerListIndex]
        var nameText = binding.speakerDetailName
        nameText.text = "${speaker.name}"
        var photoImage = binding.speakerDetailPhoto
        val photoName =  speaker.photo
        val resources: Resources = this.resources
        val resourceId: Int = resources.getIdentifier(
            photoName, "drawable",
            context?.packageName
        )
        photoImage.setImageResource(resourceId)
        var bio = binding.speakerDetailBiography
        bio.text = "${speaker.biography}"
        var twitter = binding.speakerDetailTwitter
        twitter.text = "twitter: ${speaker.twitter}"
    }
}