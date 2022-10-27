package com.example.incrediblecompose.domain.usecase

import com.example.incrediblecompose.data.Resource
import com.example.incrediblecompose.domain.model.Country
import com.example.incrediblecompose.domain.repository.CountryRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class GetCountryListUseCase(private val countryRepo: CountryRepo)  {
    operator fun invoke():Flow<Resource<List<Country>>> = flow {

        emit(Resource.Loading())
        try{
            emit(Resource.Success(data = countryRepo.getCountryList()))

        }catch (e:Exception){
            emit(Resource.Error(message = e.message.toString()))
        }
    }.flowOn(Dispatchers.IO)


}