import com.idx.oem.chrysler.TestDomain

class BootStrap {

    def vinService

    def init = { servletContext ->
        def tests = []
        tests.add(new TestDomain(vin: "12345"))
        tests.add(new TestDomain(vin: "67890"))

        tests.each{ vin ->
            if(vinService.validate(vin)) {
                vinService.save(vin)
            }
        }

        def saved = TestDomain.findAll()
        saved.each { test ->
            println "saved: ${test.vin}"
        }
    }

    def destroy = {
    }
}
