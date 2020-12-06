package com.dimitri.le.torriellec.weatheralert.ui.home

import com.dimitri.le.torriellec.weatheralert.domain.usecase.AddCityUseCase
import com.dimitri.le.torriellec.weatheralert.domain.usecase.GetCitiesUseCase
import com.dimitri.le.torriellec.weatheralert.ui.common.BaseViewModel
import com.dimitri.le.torriellec.weatheralert.ui.mapper.CitiesUiMapper
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class HomeViewModel(
    getCitiesUseCase: GetCitiesUseCase,
    val addCityUseCase: AddCityUseCase,
    private val getCitiesUiMapper: CitiesUiMapper
) : BaseViewModel<List<String>>() {
    init {
        getCitiesUseCase()
            .subscribeOn(Schedulers.io())
            .map { cvsCities ->
                getCitiesUiMapper.toUi(cvsCities)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { cities ->
                postUiData(cities)
            }
    }

    fun saveCity(city: String) {
        addCityUseCase(city)
    }

    private companion object {
        private val TAG = HomeViewModel::class.java.simpleName
    }
}