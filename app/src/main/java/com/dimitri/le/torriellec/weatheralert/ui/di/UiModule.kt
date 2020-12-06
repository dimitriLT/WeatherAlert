package com.dimitri.le.torriellec.weatheralert.ui.di

import com.dimitri.le.torriellec.weatheralert.ui.home.HomeViewModel
import com.dimitri.le.torriellec.weatheralert.ui.mapper.CitiesUiMapper
import com.dimitri.le.torriellec.weatheralert.ui.mapper.WeatherUiMapper
import com.dimitri.le.torriellec.weatheralert.ui.weather.WeatherViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiViewModelModule = module {
    single {
        CitiesUiMapper()
    }

    single {
        WeatherUiMapper()
    }

    viewModel {
        HomeViewModel(
            getCitiesUseCase = get(),
            getCitiesUiMapper = get(),
            addCityUseCase = get()
        )
    }

    viewModel {
        WeatherViewModel(
            getWeatherUseCase = get(),
            getWeatherUiMapper = get()
        )
    }
}


val koinUiModules = listOf(
    uiViewModelModule
)
