package com.example.incrediblecompose.ui.countryDetails

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.incrediblecompose.domain.presentation.CountryDetail.CountryDetailViewModel

@Composable
fun CountryDetails(countryName:String,viewModel: CountryDetailViewModel = hiltViewModel()){

    Scaffold(topBar = { TopAppBar(title = { Text(text = countryName) }) }) {

        val res = viewModel.countryDetail.value

        if (res.isLoading){
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
        if (!res.error.isNullOrEmpty()){
            Text(text = res.error.toString())
        }

        res.data?.let {

        }

        }

}