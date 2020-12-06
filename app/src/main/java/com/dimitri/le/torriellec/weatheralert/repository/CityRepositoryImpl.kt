package com.dimitri.le.torriellec.weatheralert.repository

import android.content.SharedPreferences
import com.dimitri.le.torriellec.weatheralert.domain.CityRepository
import io.reactivex.Observable
import io.reactivex.subjects.BehaviorSubject
import org.koin.core.KoinComponent
import org.koin.core.inject

class CityRepositoryImpl : CityRepository, KoinComponent {

    private val preferences: SharedPreferences by inject()

    private val prefSubject = BehaviorSubject.createDefault(preferences)

    private val prefChangeListener =
        SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, _ ->
            prefSubject.onNext(sharedPreferences)
        }

    companion object {
        private const val CITY = "City"

    }

    init {
        preferences.registerOnSharedPreferenceChangeListener(prefChangeListener)
    }

    override fun getCities(): Observable<String> =
        prefSubject.map { it.getString(CITY, "") }


    override fun addCity(city: String) {
        val editor = preferences.edit()
        val cities = preferences.getString(CITY, "")
        editor.putString(CITY, "$cities,$city").commit()
    }


}