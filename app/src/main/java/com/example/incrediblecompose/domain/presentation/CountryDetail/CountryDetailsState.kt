package com.example.incrediblecompose.domain.presentation.CountryDetail

import com.example.incrediblecompose.domain.model.CountryDetails


data class CountryDetailsState(
    val isLoading:Boolean=false,
    val error:String="",
    val data: CountryDetails?=null
)
