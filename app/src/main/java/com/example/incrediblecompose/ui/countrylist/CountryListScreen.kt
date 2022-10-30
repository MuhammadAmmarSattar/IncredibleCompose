package com.example.incrediblecompose.ui.countrylist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.incrediblecompose.domain.model.Country
import com.example.incrediblecompose.domain.presentation.CountryList.CountryListViewModel
import com.example.incrediblecompose.domain.presentation.navigation.Navigations


@Composable
fun CountryListScreen(viewModel: CountryListViewModel = hiltViewModel()) {

    val res = viewModel.countryList.value
    Scaffold(topBar = { TopAppBar(title = { Text(text = "Country List") }) }) {
        if (res.isLoading) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        if (res.error.isNotBlank()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = res.error.toString())
            }
        }
        res.data?.let { countryList ->
            LazyColumn {
                items(countryList) {
                    CountryListItems(country = it) {
//                        Navigations()
                    }
                }
            }
        }

    }

}


@Composable
fun CountryListItems(country: Country, onClickListener: (String) -> Unit) {

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                onClickListener.invoke(country.name)
            }
    ) {
        Text(
            text = country.name,
            modifier = Modifier.padding(8.dp),
            style = TextStyle(color = Color.Black, fontSize = 18.sp)
        )
    }
}