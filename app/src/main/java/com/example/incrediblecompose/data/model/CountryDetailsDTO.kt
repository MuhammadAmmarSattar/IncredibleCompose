package com.example.incrediblecompose.data.model

data class CountryDetailsDTO(
    val currency: CurrencyDTO?,
    val electricity: ElectricityDTO?,
    val language: List<LanguageDTO>?,
    val names: NamesDTO?,
    val neighbors: List<NeighborDTO>?,
    val telephone: TelephoneDTO?,
    val timezone: TimezoneDTO?,
    val vaccinations: List<VaccinationDTO>?,
    val water: WaterDTO?
)
data class CurrencyDTO(
    val code: String?,
    val compare: List<CompareDTO>?,
    val name: String?,
    val rate: String?,
    val symbol: String?
)
data class CompareDTO(
    val name: String?=null,
    val rate: String?=null
)

data class ElectricityDTO(
    val frequency: String?=null,
    val plugs: List<String>?=null,
    val voltage: String?=null
)

data class LanguageDTO(
    val language: String?=null,
    val official: String?=null
)

data class NamesDTO(
    val continent: String?,
    val full: String?,
    val iso2: String?,
    val iso3: String?,
    val name: String?
)

data class NeighborDTO(
    val id: String?,
    val name: String?
)

data class TelephoneDTO(
    val ambulance: String?,
    val calling_code: String?,
    val fire: String?,
    val police: String?
)

data class TimezoneDTO(
    val name: String?
)

data class VaccinationDTO(
    val message: String?,
    val name: String?
)

data class WaterDTO(
    val full: String,
    val short: String
)