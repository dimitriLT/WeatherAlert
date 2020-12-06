package com.dimitri.le.torriellec.weatheralert.repository.api

import com.dimitri.le.torriellec.weatheralert.BuildConfig
import com.dimitri.le.torriellec.weatheralert.repository.ApiDataSource
import com.dimitri.le.torriellec.weatheralert.repository.api.model.WeatherResponse
import com.dimitri.le.torriellec.weatheralert.repository.api.retrofit.ApiService
import io.reactivex.Single

class ApiDataSourceImpl(
    private val apiService: ApiService
) : ApiDataSource {
    override fun getWeather(city: String): Single<WeatherResponse> {
        return apiService.getWeather(city, BuildConfig.API_KEY)
    }

}