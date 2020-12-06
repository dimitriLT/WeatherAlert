package com.dimitri.le.torriellec.weatheralert.repository.mapper

abstract class BaseDomainMapper<API, DOMAIN> {

    abstract fun toDomain(api: API): DOMAIN
}