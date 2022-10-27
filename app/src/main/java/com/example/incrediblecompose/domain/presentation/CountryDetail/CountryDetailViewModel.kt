package com.example.incrediblecompose.domain.presentation.CountryDetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.incrediblecompose.data.Resource
import com.example.incrediblecompose.domain.usecase.GetCountryDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryDetailViewModel @Inject constructor(private val getCountryDetailsUseCase: GetCountryDetailsUseCase) :
    ViewModel() {


    private val _countryDetail = mutableStateOf(CountryDetailsState())
    val countryDetail: State<CountryDetailsState> = _countryDetail


    fun getCountryDetail(countryName: String) {
        getCountryDetailsUseCase(countryName).onEach {
            when (it) {
                is Resource.Error -> {
                    _countryDetail.value = CountryDetailsState(error = it.message.toString())
                }
                is Resource.Loading -> {
                    _countryDetail.value = CountryDetailsState(isLoading = true)
                }
                is Resource.Success -> {
                    _countryDetail.value = CountryDetailsState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }

}