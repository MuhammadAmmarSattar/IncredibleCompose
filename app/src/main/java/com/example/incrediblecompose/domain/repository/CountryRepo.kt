package com.example.incrediblecompose.domain.repository

import com.example.incrediblecompose.domain.model.Country
import com.example.incrediblecompose.domain.model.CountryDetails

interface CountryRepo {

    suspend fun getCountryList():List<Country>
    suspend fun getCountryDetails(countryName:String): CountryDetails

}