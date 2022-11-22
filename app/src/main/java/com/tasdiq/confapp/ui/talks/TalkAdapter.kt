package com.tasdiq.confapp.ui.talks

import android.content.Context
import android.content.res.Resources
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cjp.confapp.model.ConfViewModel
import com.cjp.speaker2.ui.main.SpeakerAdapter
import com.tasdiq.confapp.R

class TalkAdapter (private val context: Context, val clickListener: TalkAdapter.TalkClickListener, val viewModel: ConfViewModel)  : RecyclerView.Adapter<TalkAdapter.TalkViewHolder>() {

    class TalkViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val startTime : TextView = view.findViewById(R.id.startTime)
        val endTime : TextView = view.findViewById(R.id.endTime)
        val talkDate : TextView = view.findViewById(R.id.talk_date)
        val talkName : TextView = view.findViewById(R.id.talk_name)
        val talkSpeaker : TextView = view.findViewById(R.id.talk_speaker)
    }

    interface TalkClickListener{
        fun listItemClicked( choice: Int )
    }

    override fun getItemCount(): Int {
        return viewModel.allTalks.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TalkAdapter.TalkViewHolder {
        var view = LayoutInflater.from(p0.context)
            .inflate(R.layout.talk_adapter, p0, false)
        return TalkAdapter.TalkViewHolder(view)
    }

    override fun onBindViewHolder(holder : TalkAdapter.TalkViewHolder, index: Int) {
        holder.startTime.text = viewModel.allTalks[index].timeStart
        holder.endTime.text = viewModel.allTalks[index].timeEnd
        val date = viewModel.allTalks[index].sessionDate
        holder.talkDate.text = viewModel.dayName(date)
        holder.talkName.text = viewModel.allTalks[index].title
        val speakerId = viewModel.allTalks[index].speakerId
        holder.talkSpeaker.text = viewModel.speakerNameFromSpeakerId(speakerId)
        val myTalk = viewModel.allTalks[index]
        if (myTalk.sessionType == "talk" || myTalk.sessionType == "workshop" ) {
            holder.itemView.setOnClickListener({ clickListener.listItemClicked(index) })
        } else {
            holder.view.setBackgroundColor(Color.parseColor("#00cc00"))
        }
    }
}