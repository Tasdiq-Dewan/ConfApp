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
import com.tasdiq.confapp.model.ConfViewModel
import com.tasdiq.confapp.R
import com.tasdiq.confapp.model.Talk

class TalkAdapter (private val context: Context, val clickListener: TalkAdapter.TalkClickListener, val viewModel: ConfViewModel, val favourites : Boolean)  : RecyclerView.Adapter<TalkAdapter.TalkViewHolder>() {

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
        if(favourites){
            return viewModel.favourites.size
        }
        return viewModel.allTalks.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TalkAdapter.TalkViewHolder {
        var view = LayoutInflater.from(p0.context)
            .inflate(R.layout.talk_adapter, p0, false)
        return TalkAdapter.TalkViewHolder(view)
    }

    override fun onBindViewHolder(holder : TalkAdapter.TalkViewHolder, index: Int) {
        val talk : Talk
        if(favourites){
            talk = viewModel.favourites[index]
        }
        else{
            talk = viewModel.allTalks[index]
        }
        holder.startTime.text = talk.timeStart
        holder.endTime.text = talk.timeEnd
        val date = talk.sessionDate
        holder.talkDate.text = viewModel.dayName(date)
        holder.talkName.text = talk.title
        val speakerId = talk.speakerId
        holder.talkSpeaker.text = viewModel.speakerNameFromSpeakerId(speakerId)
        if (talk.sessionType == "talk" || talk.sessionType == "workshop" ) {
            holder.itemView.setOnClickListener({ clickListener.listItemClicked(index) })
        } else {
            holder.view.setBackgroundColor(Color.parseColor("#00cc00"))
        }
    }
}