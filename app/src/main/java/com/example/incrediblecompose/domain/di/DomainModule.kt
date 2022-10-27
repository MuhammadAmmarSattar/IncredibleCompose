package com.example.incrediblecompose.domain.di

import com.example.incrediblecompose.domain.model.CountryDetails
import com.example.incrediblecompose.domain.repository.CountryRepo
import com.example.incrediblecompose.domain.usecase.GetCountryDetailsUseCase
import com.example.incrediblecompose.domain.usecase.GetCountryListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object DomainModule {


    @Provides
    fun provideCountryListUseCase(countryRepo: CountryRepo):GetCountryListUseCase{
        return GetCountryListUseCase(countryRepo)
    }


    @Provides
    fun provideCountryDetailUseCase(countryRepo:CountryRepo):GetCountryDetailsUseCase{
        return GetCountryDetailsUseCase(countryRepo)
    }
}