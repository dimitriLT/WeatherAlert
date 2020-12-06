package com.dimitri.le.torriellec.weatheralert.domain

import io.reactivex.Observable

interface CityRepository {

    fun getCities(): Observable<String>

    fun addCity(city: String)
}