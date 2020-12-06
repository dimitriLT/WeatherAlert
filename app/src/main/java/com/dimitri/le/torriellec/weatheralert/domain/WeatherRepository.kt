package com.dimitri.le.torriellec.weatheralert.domain

import com.dimitri.le.torriellec.weatheralert.domain.model.Wind
import io.reactivex.Single

interface WeatherRepository {

    fun getWeather(city: String): Single<Wind>
}