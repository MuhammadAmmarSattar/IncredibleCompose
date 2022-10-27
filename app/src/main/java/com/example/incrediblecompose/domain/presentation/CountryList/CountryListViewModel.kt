package com.example.incrediblecompose.domain.presentation.CountryList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.incrediblecompose.data.Resource
import com.example.incrediblecompose.domain.usecase.GetCountryListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CountryListViewModel @Inject constructor(private val getCountryListUseCase: GetCountryListUseCase):ViewModel(){


    private val _countryList = mutableStateOf(CountryListState())
    private val countryList : State<CountryListState> = _countryList


    init {
        getCountryList()
    }

    fun getCountryList(){
        getCountryListUseCase().onEach {
            when(it){
                is Resource.Loading->{
                    _countryList.value = CountryListState(isLoading = true)
                }
                is Resource.Error -> {
                    _countryList.value = CountryListState(error = it.message.toString())
                }
                is Resource.Success -> {
                    _countryList.value = CountryListState(data = it.data)
                }
            }
        }.launchIn(viewModelScope)
    }
}