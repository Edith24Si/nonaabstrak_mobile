package com.example.nona_abstrak.data.api

import com.example.nona_abstrak.data.model.CatFactModel
import retrofit2.http.GET

interface CatFactApiService {
    @GET("fact")
    suspend fun getCatFact(): CatFactModel
}