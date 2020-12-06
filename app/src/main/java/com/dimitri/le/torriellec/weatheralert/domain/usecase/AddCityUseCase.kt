package com.dimitri.le.torriellec.weatheralert.domain.usecase

import com.dimitri.le.torriellec.weatheralert.domain.CityRepository

class AddCityUseCase(
    private val repository: CityRepository
) {

    operator fun invoke(city: String) {
        return repository.addCity(city)
    }

}