import com.idx.oem.chrysler.TestDomain
import com.idx.oem.chrysler.VinService
import grails.core.GrailsApplication
import org.grails.io.support.ClassPathResource

import javax.servlet.ServletContext

class BootStrap {

    GrailsApplication grailsApplication
    VinService vinService

    def init = { ServletContext ctx ->

        // clear out old data
        TestDomain.executeUpdate("delete from TestDomain")

        def dbUrl = grailsApplication.config.getProperty('dataSource.url')
        println "database url = ${dbUrl}"

        def file1 = new ClassPathResource('public/data.txt').file
        println "file = ${file1.absolutePath}"

        String fileContents = file1.text
        def tokens = fileContents.split(",")

        tokens.each { token ->
            println token
        }

        def tests = []
        tests.add(new TestDomain(vin: "T4-12345"))
        tests.add(new TestDomain(vin: "T4-67890"))

        tests.each{ vin ->
            if(vinService.validate(vin)) {
                vinService.save(vin)
            }
        }

        def saved = TestDomain.findAll()
        saved.each { TestDomain test ->
            println "saved: ${test.vin}"
        }

    }

    def destroy = {
    }
}
