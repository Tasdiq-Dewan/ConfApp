package com.tasdiq.confapp.ui.locations

import android.content.Context
import android.content.res.Resources
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cjp.confapp.model.ConfViewModel
import com.cjp.speaker2.ui.main.SpeakerAdapter
import com.tasdiq.confapp.R

class LocationAdapter (private val context: Context, val clickListener: LocationClickListener, val viewModel: ConfViewModel) : RecyclerView.Adapter<LocationAdapter.LocationViewHolder>() {

    class LocationViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val locationName: TextView = view.findViewById(R.id.location_name)

        val locationImage: ImageView = view.findViewById(R.id.locationImage)
    }

    interface LocationClickListener{
        fun listItemClicked( choice: Int )
    }

    override fun getItemCount(): Int {
        return viewModel.allLocations.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): LocationAdapter.LocationViewHolder {
        var view = LayoutInflater.from(p0.context)
            .inflate(R.layout.location_adapter, p0, false)
        return LocationAdapter.LocationViewHolder(view)
    }

    override fun onBindViewHolder(holder : LocationAdapter.LocationViewHolder, index: Int) {
        holder.locationName.text = viewModel.allLocations[index].name
        val resources: Resources = context.resources
        val resourceId: Int = resources.getIdentifier(
            viewModel.allLocations[index].id, "drawable",
            context.packageName
        )
        holder.locationImage.setImageResource(resourceId)
        holder.itemView.setOnClickListener{clickListener.listItemClicked(index)}
    }
}