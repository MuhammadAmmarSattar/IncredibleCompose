package com.example.incrediblecompose.domain.presentation.navigation

sealed class NavigationItem(val route:String){
    object CountryListNavigationItem : NavigationItem("country_list")
    object CountryNavigationDetailsItem : NavigationItem(route= "country_details/{country_name}")
}
