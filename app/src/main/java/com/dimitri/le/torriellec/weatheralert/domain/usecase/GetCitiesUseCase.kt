package com.dimitri.le.torriellec.weatheralert.domain.usecase

import com.dimitri.le.torriellec.weatheralert.domain.CityRepository
import io.reactivex.Observable

class GetCitiesUseCase(
    private val repository: CityRepository
) {

    operator fun invoke(): Observable<String> {
        return repository.getCities()
    }

}