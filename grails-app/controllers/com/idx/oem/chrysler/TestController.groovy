package com.idx.oem.chrysler


import grails.rest.*

class TestController extends RestfulController {
    static responseFormats = ['json', 'xml']
    TestController() {
        super(TestDomain)
    }
}
