package com.example.nona_abstrak.data.api

import com.example.nona_abstrak.data.model.PhotoModel
import retrofit2.http.GET

interface PhotoApiService {
    @GET("list")
    suspend fun getPhotos(): List<PhotoModel>
}