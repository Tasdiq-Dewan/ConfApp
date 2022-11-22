package com.tasdiq.confapp.model

@kotlinx.serialization.Serializable
class Location(
    val id: String,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val placeDescription: String){
}
