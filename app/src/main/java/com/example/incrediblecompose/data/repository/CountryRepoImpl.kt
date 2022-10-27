package com.example.incrediblecompose.data.repository

import com.example.incrediblecompose.data.mapper.toDomain
import com.example.incrediblecompose.data.network.ApiService
import com.example.incrediblecompose.domain.model.Country
import com.example.incrediblecompose.domain.model.CountryDetails
import com.example.incrediblecompose.domain.repository.CountryRepo


class CountryRepoImpl(private val apiService: ApiService) : CountryRepo {
    override suspend fun getCountryList(): List<Country> {
        return apiService.getCountryList().map { it.toDomain() }
    }

    override suspend fun getCountryDetails(countryName: String): CountryDetails {
       return apiService.getCountryDetails(countryName = countryName).toDomain()
    }

}