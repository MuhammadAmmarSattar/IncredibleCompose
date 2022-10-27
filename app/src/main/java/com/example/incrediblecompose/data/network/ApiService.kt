package com.example.incrediblecompose.data.network

import com.example.incrediblecompose.data.model.CountryDTO
import com.example.incrediblecompose.data.model.CountryDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


    @GET("countries.json")
    suspend fun getCountryList():List<CountryDTO>


    @GET("{country_name}")
    suspend fun getCountryDetails(
        @Path("country_name") countryName:String,
        @Query("format") format:String="json"
    ): CountryDetailsDTO


}