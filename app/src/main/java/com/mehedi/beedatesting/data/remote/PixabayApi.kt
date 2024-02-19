package com.mehedi.beedatesting.data.remote

import com.mehedi.beedatesting.data.remote.responses.ImageResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface PixabayApi {

    @GET("api/")
    suspend fun searchForImages(
        @Query("q") searchQuery: String,
        @Query("key") apiKey: String = "42449433-9de88cc384639f51241a586df"
    ): Response<ImageResponse>


}