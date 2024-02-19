package com.mehedi.beedatesting.data.remote.responses

data class ImageResponse(
    val hits: List<ImageResult>,
    val total: Int,
    val totalHits: Int
)