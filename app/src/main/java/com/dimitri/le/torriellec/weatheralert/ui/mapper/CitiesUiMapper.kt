package com.dimitri.le.torriellec.weatheralert.ui.mapper

import com.dimitri.le.torriellec.weatheralert.ui.common.BaseUiMapper

class CitiesUiMapper : BaseUiMapper<String, List<String>>() {

    override fun toUi(domain: String): List<String> {
        return domain.split(",")
    }

}