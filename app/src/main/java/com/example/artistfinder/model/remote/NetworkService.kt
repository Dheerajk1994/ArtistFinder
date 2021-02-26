package com.example.artistfinder.model.remote

import com.example.artistfinder.model.result.ApiResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkService{
    @GET("/search")
    fun getTracks(@Query("term")term : String) : Single<ApiResult>
}