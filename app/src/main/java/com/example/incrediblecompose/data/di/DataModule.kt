package com.example.incrediblecompose.data.di

import com.example.incrediblecompose.data.network.ApiService
import com.example.incrediblecompose.data.repository.CountryRepoImpl
import com.example.incrediblecompose.domain.repository.CountryRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
object DataModule {

    @Singleton
    @Provides
    fun provideAPiService(): ApiService {
        return Retrofit.Builder().baseUrl("").addConverterFactory(GsonConverterFactory.create())
            .build().create(ApiService::class.java)

    }

    @Provides
    fun provideCountryRepo(apiService: ApiService):CountryRepo{
        return CountryRepoImpl(apiService)
    }
}