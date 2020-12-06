package com.dimitri.le.torriellec.weatheralert.repository

import com.dimitri.le.torriellec.weatheralert.domain.WeatherRepository
import com.dimitri.le.torriellec.weatheralert.domain.model.Wind
import com.dimitri.le.torriellec.weatheralert.repository.mapper.WeatherMapper
import io.reactivex.Single

class WeatherRepositoryImpl(
    private val apiDataSource: ApiDataSource,
    private val weatherMapper: WeatherMapper
) : WeatherRepository {

    override fun getWeather(city: String): Single<Wind> {
        return apiDataSource.getWeather(city).map { weathersResponse ->
            weatherMapper.toDomain(weathersResponse)

        }
    }

}