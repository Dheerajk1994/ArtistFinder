package com.example.artistfinder.model.result

data class ApiResult(val results : MutableList<TrackPoko>)

data class TrackPoko(
        var artistName : String,
        var trackName : String,
        var releaseDate : String,
        var trackPrice : String,
        var primaryGenreName : String
)