package com.example.incrediblecompose.domain.usecase

import com.example.incrediblecompose.data.Resource
import com.example.incrediblecompose.domain.model.CountryDetails
import com.example.incrediblecompose.domain.repository.CountryRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCountryDetailsUseCase (private val countryRepo: CountryRepo) {
    operator fun invoke(countryName : String):Flow<Resource<CountryDetails>>  = flow {
        emit(Resource.Loading())
        try {
            emit(Resource.Success(data=countryRepo.getCountryDetails(countryName=countryName)))

        }catch (e:Exception){
            emit(Resource.Error(message = e.message.toString()))

        }
    }.flowOn(Dispatchers.IO)
}