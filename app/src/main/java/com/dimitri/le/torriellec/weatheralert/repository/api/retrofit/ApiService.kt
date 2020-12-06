package com.dimitri.le.torriellec.weatheralert.repository.api.retrofit

import com.dimitri.le.torriellec.weatheralert.repository.api.model.WeatherResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/weather?")
    fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String
    ): Single<WeatherResponse>

}
