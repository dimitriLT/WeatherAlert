package com.dimitri.le.torriellec.weatheralert.repository.mapper

import com.dimitri.le.torriellec.weatheralert.domain.model.Wind
import com.dimitri.le.torriellec.weatheralert.repository.api.model.WeatherResponse

class WeatherMapper : BaseDomainMapper<WeatherResponse, Wind>() {
    override fun toDomain(api: WeatherResponse): Wind {
        return Wind(
            deg = api.wind.deg,
            speed = api.wind.speed
        )
    }
}