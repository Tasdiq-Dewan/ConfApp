package com.tasdiq.confapp.model

@kotlinx.serialization.Serializable
class Talk (
    var id: String,
    var title: String,
    var content: String,
    var locationId: String,
    var sessionDate: String,
    var sessionOrder: Int,
    var timeStart: String,
    var timeEnd: String,
    var sessionType: String,
    var speakerId: String ){
}
