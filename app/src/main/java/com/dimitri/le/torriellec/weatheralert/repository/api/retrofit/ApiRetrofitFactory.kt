package com.dimitri.le.torriellec.weatheralert.repository.api.retrofit

import android.content.Context
import com.dimitri.le.torriellec.weatheralert.BuildConfig
import com.dimitri.le.torriellec.weatheralert.repository.network.RetrofitFactory.buildHttpClient
import com.dimitri.le.torriellec.weatheralert.repository.network.RetrofitFactory.buildMoshi
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class ApiRetrofitFactory(private val context: Context) {

    fun buildApiRetrofit(): Retrofit {
        return Retrofit.Builder()
            .client(buildHttpClient())
            .baseUrl(BuildConfig.API_ADDRESS)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create(buildMoshi()))
            .build()
    }

    fun buildApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
