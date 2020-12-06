package com.dimitri.le.torriellec.weatheralert.domain.usecase

import com.dimitri.le.torriellec.weatheralert.domain.WeatherRepository
import com.dimitri.le.torriellec.weatheralert.domain.model.Wind
import io.reactivex.Single

class GetWeatherUseCase(
    private val repository: WeatherRepository
) {

    operator fun invoke(city: String): Single<Wind> {
        return repository.getWeather(city)
    }
}