package com.cjp.speaker2.ui.main

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.tasdiq.confapp.model.ConfViewModel
import com.tasdiq.confapp.R

class SpeakerAdapter(private val context: Context, val clickListener: SpeakerClickListener, val viewModel: ConfViewModel) : RecyclerView.Adapter<SpeakerAdapter.SpeakerViewHolder>() {

    class SpeakerViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.speaker_name)

        val speakerImage: ImageView = view.findViewById(R.id.speakerImage)
    }

    interface SpeakerClickListener{
        fun listItemClicked( choice: Int )
    }

    override fun getItemCount(): Int {
        return viewModel.allSpeakers.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SpeakerViewHolder {
        var view = LayoutInflater.from(p0.context)
            .inflate(R.layout.speaker_adapter, p0, false)
        return SpeakerViewHolder(view)
    }

    override fun onBindViewHolder(p0: SpeakerViewHolder, p1: Int) {
        p0.textView.text = viewModel.allSpeakers[p1].name
        val resources: Resources = context.resources
        val resourceId: Int = resources.getIdentifier(
            viewModel.allSpeakers[p1].photo, "drawable",
            context.packageName
        )
        p0.speakerImage.setImageResource(resourceId)
        p0.itemView.setOnClickListener({clickListener.listItemClicked(p1)})
    }
}