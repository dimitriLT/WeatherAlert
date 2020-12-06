package com.dimitri.le.torriellec.weatheralert.domain.di

import com.dimitri.le.torriellec.weatheralert.domain.usecase.AddCityUseCase
import com.dimitri.le.torriellec.weatheralert.domain.usecase.GetCitiesUseCase
import com.dimitri.le.torriellec.weatheralert.domain.usecase.GetWeatherUseCase
import org.koin.dsl.module

val domainUseCaseModule = module {
    factory {
        GetWeatherUseCase(
            repository = get()
        )
    }
    factory {
        GetCitiesUseCase(
            repository = get()
        )
    }
    factory {
        AddCityUseCase(
            repository = get()
        )
    }
}

val koinDomainModules = listOf(
    domainUseCaseModule
)