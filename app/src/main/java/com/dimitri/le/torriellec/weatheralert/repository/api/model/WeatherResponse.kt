package com.dimitri.le.torriellec.weatheralert.repository.api.model

data class WeatherResponse(
    val coord: CoordApi,
    val sys: SysApi,
    val weather: List<WeatherApi> = ArrayList(),
    val main: MainApi,
    val wind: WindApi,
    val dt: Float,
    val id: Int,
    val name: String,
    val cod: Float
)

data class WindApi(
    val speed: Float,
    val deg: Float
)

data class MainApi(
    val temp: Float,
    val humidity: Float,
    val pressure: Float,
    val temp_min: Float,
    val temp_max: Float
)

data class WeatherApi(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class SysApi(
    val country: String,
    val sunrise: Long,
    val sunset: Long
)

data class CoordApi(
    val lon: Float,
    val lat: Float
)
