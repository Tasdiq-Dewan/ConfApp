package com.tasdiq.confapp.model

@kotlinx.serialization.Serializable
class Speaker(
    val id: String,
    val photo: String,
    val name: String,
    val biography: String,
    val twitter: String){
}
