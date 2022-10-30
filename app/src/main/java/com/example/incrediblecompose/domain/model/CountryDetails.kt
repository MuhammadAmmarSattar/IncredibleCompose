package com.example.incrediblecompose.domain.model

data class CountryDetails(
    val currency: Currency,
    val electricity: Electricity,
    val language: List<Language>,
    val names: Names,
    val neighbors: List<Neighbor>,
    val telephone: Telephone,
    val timezone: Timezone,
    val vaccinations: List<Vaccination>,
    val water: Water,
)

data class Currency(
    val code: String,
    val compare: List<Compare>,
    val name: String,
    val rate: String,
    val symbol: String
)
data class Compare(
    val name: String,
    val rate: String
)

data class Electricity(
    val frequency: String,
    val voltage: String
)

data class Language(
    val language: String,
    val official: String
)

data class Names(
    val continent: String,
    val full: String,
    val iso2: String,
    val iso3: String,
    val name: String
)

data class Neighbor(
    val id: String,
    val name: String
)

data class Telephone(
    val ambulance: String,
    val calling_code: String,
    val fire: String,
    val police: String
)

data class Timezone(
    val name: String?
)

data class Vaccination(
    val message: String,
    val name: String
)

data class Water(
    val full: String,
    val short: String
)