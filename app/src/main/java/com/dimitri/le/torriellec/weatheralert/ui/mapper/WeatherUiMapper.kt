package com.dimitri.le.torriellec.weatheralert.ui.mapper

import com.dimitri.le.torriellec.weatheralert.domain.model.Wind
import com.dimitri.le.torriellec.weatheralert.ui.common.BaseUiMapper
import com.dimitri.le.torriellec.weatheralert.ui.model.WindUi

class WeatherUiMapper : BaseUiMapper<Wind, WindUi>() {
    override fun toUi(domain: Wind): WindUi {
        return WindUi(
            deg = domain.deg.toString(),
            speed = domain.speed.toString() + " m/h"
        )
    }
}