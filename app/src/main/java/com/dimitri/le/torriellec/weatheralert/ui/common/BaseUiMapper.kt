package com.dimitri.le.torriellec.weatheralert.ui.common

abstract class BaseUiMapper<DOMAIN, UI> {

    abstract fun toUi(domain: DOMAIN): UI
}