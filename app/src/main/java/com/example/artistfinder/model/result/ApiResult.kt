package com.example.artistfinder.model.result

data class ApiResult(val list : MutableList<TrackPoko>)

data class TrackPoko(
        var artistName : String,
        var trackName : String,
        var releaseData : String,
        var trackPrice : String,
        var primaryGenreName : String
)