package com.dimitri.le.torriellec.weatheralert.repository

import com.dimitri.le.torriellec.weatheralert.repository.api.model.WeatherResponse
import io.reactivex.Single

interface ApiDataSource {

    fun getWeather(city: String): Single<WeatherResponse>

}