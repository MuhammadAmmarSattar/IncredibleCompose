package com.example.incrediblecompose.domain.presentation.CountryList

import com.example.incrediblecompose.domain.model.Country


data class CountryListState(
    val isLoading:Boolean=false,
    val error:String="",
    val data:List<Country>?=null
)
