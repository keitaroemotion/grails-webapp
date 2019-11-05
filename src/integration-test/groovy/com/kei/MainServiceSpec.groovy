package com.kei

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class MainServiceSpec extends Specification {

    MainService mainService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Main(...).save(flush: true, failOnError: true)
        //new Main(...).save(flush: true, failOnError: true)
        //Main main = new Main(...).save(flush: true, failOnError: true)
        //new Main(...).save(flush: true, failOnError: true)
        //new Main(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //main.id
    }

    void "test get"() {
        setupData()

        expect:
        mainService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Main> mainList = mainService.list(max: 2, offset: 2)

        then:
        mainList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        mainService.count() == 5
    }

    void "test delete"() {
        Long mainId = setupData()

        expect:
        mainService.count() == 5

        when:
        mainService.delete(mainId)
        sessionFactory.currentSession.flush()

        then:
        mainService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Main main = new Main()
        mainService.save(main)

        then:
        main.id != null
    }
}
