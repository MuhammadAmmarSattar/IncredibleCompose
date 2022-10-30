package com.example.incrediblecompose.domain.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.incrediblecompose.domain.model.CountryDetails
import com.example.incrediblecompose.ui.countrylist.CountryListScreen

@Composable
fun Navigations() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationItem.CountryListNavigationItem.route
    ) {
        composable(NavigationItem.CountryListNavigationItem.route) {
//            val countryName = it.arguments?.getString("country_name")
//            CountryDetails(countryName = countryName.toString())
        }
        composable(NavigationItem.CountryListNavigationItem.route) {
            CountryListScreen()
        }

    }
}