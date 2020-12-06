package com.dimitri.le.torriellec.weatheralert.ui.weather

import android.util.Log
import com.dimitri.le.torriellec.weatheralert.domain.usecase.GetWeatherUseCase
import com.dimitri.le.torriellec.weatheralert.ui.common.BaseViewModel
import com.dimitri.le.torriellec.weatheralert.ui.mapper.WeatherUiMapper
import com.dimitri.le.torriellec.weatheralert.ui.model.WindUi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers

class WeatherViewModel(
    val getWeatherUseCase: GetWeatherUseCase,
    private val getWeatherUiMapper: WeatherUiMapper
) : BaseViewModel<WindUi>() {
    fun getWeather(city: String) {
        getWeatherUseCase(city)
            .subscribeOn(Schedulers.io())
            .map { wind ->
                getWeatherUiMapper.toUi(wind)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(
                onSuccess = { windUi ->
                    postUiData(windUi)
                },
                onError = {
                    Log.e(TAG, "error when getting wind", it)
                }
            )
    }

    private companion object {
        private val TAG = WeatherViewModel::class.java.simpleName
    }
}