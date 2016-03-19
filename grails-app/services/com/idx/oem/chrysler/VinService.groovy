package com.idx.oem.chrysler

import grails.transaction.Transactional

@Transactional
class VinService {

    boolean validate(TestDomain test){
        test.validate()
    }

    void save(TestDomain test) {
        test.save(flush: true)
    }
}
