package com.kei

import grails.gorm.services.Service

@Service(Main)
interface MainService {

    Main get(Serializable id)

    List<Main> list(Map args)

    Long count()

    void delete(Serializable id)

    Main save(Main main)

}