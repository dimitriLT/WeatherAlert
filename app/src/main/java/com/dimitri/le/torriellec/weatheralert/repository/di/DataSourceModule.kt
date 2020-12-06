package com.dimitri.le.torriellec.weatheralert.repository.di

import android.content.Context
import com.dimitri.le.torriellec.weatheralert.domain.CityRepository
import com.dimitri.le.torriellec.weatheralert.domain.WeatherRepository
import com.dimitri.le.torriellec.weatheralert.repository.ApiDataSource
import com.dimitri.le.torriellec.weatheralert.repository.CityRepositoryImpl
import com.dimitri.le.torriellec.weatheralert.repository.WeatherRepositoryImpl
import com.dimitri.le.torriellec.weatheralert.repository.api.ApiDataSourceImpl
import com.dimitri.le.torriellec.weatheralert.repository.api.retrofit.ApiRetrofitFactory
import com.dimitri.le.torriellec.weatheralert.repository.mapper.WeatherMapper
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val apiRetrofitModule = module {
    single {
        ApiRetrofitFactory(androidContext()).buildApiService(
            ApiRetrofitFactory(androidContext()).buildApiRetrofit()
        )
    }
}

val apiDataSourceModule = module {
    single {
        ApiDataSourceImpl(
            apiService = get()
        ) as ApiDataSource
    }
}

val apiMapperModule = module {
    single {
        WeatherMapper()
    }
}

val repositoryModule = module {
    single {
        WeatherRepositoryImpl(
            apiDataSource = get(),
            weatherMapper = get()
        ) as WeatherRepository
    }

    single {
        CityRepositoryImpl() as CityRepository
    }

    single {
        androidApplication().getSharedPreferences("Favourite", Context.MODE_PRIVATE)
    }

}

val koinDataSourceModules = listOf(
    apiRetrofitModule,
    apiDataSourceModule,
    apiMapperModule,
    repositoryModule
)