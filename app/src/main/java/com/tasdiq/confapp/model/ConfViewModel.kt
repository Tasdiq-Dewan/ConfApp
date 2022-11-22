package com.tasdiq.confapp.model

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ConfViewModel : ViewModel() {

    companion object {
        fun newInstance() = ConfViewModel()
    }

    var allTalks : List<Talk> = listOf()
    var allLocations : List<Location> = listOf()
    var allSpeakers : List<Speaker> = listOf()

    fun loadConfDataFromFile(context: FragmentActivity){
        val locationsString = stringFromAssetFile("locations.json", context)
        allLocations = Json.decodeFromString<List<Location>>(locationsString)
        val talksString = stringFromAssetFile("talks.json", context)
        allTalks = Json.decodeFromString<List<Talk>>(talksString)
        val speakerString = stringFromAssetFile("speakers.json", context)
        allSpeakers = Json.decodeFromString<List<Speaker>>(speakerString)
    }

    fun stringFromAssetFile(assetName: String, context: FragmentActivity): String{
        val bufferReader = context.assets.open(assetName).bufferedReader()
        val answer = bufferReader.use {
            it.readText()
        }
        return answer
    }

    fun speakerNameFromSpeakerId( speakerId: String): String {
        val speakerLookup = allSpeakers.filter { it.id == speakerId }
        var result = ""
        if (speakerLookup.size > 0) {
            result = speakerLookup[0].name
        }
        return result
    }

    fun locationNameFromLocationId( locationId: String): String {
        val locationLookup = allLocations.filter { it.id == locationId }
        var result = ""
        if (locationLookup.size > 0) {
            result = locationLookup[0].name
        }
        return result
    }

    fun speakerIndexFromSpeakerId( speakerId: String): Int {
    var result = 0
       for (speaker in allSpeakers) {
           if (speaker.id == speakerId) { return result }
           else result = result + 1
       }
       return 0
    }


    fun dayName(dateString: String): String {
        var result = "Monday 10th"
        if (dateString == "2019-12-11") {
            result = "Tuesday 11th"
        } else if (dateString == "2019-12-12") {
            result = "Wednesday 12th"
        } else if (dateString == "2019-12-13") {
            result = "Thursday 13th"
        }
        return result
    }

}
