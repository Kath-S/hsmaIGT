package server

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class AdressServiceSpec extends Specification {

    AdressService adressService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Adress(...).save(flush: true, failOnError: true)
        //new Adress(...).save(flush: true, failOnError: true)
        //Adress adress = new Adress(...).save(flush: true, failOnError: true)
        //new Adress(...).save(flush: true, failOnError: true)
        //new Adress(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //adress.id
    }

    void "test get"() {
        setupData()

        expect:
        adressService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Adress> adressList = adressService.list(max: 2, offset: 2)

        then:
        adressList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        adressService.count() == 5
    }

    void "test delete"() {
        Long adressId = setupData()

        expect:
        adressService.count() == 5

        when:
        adressService.delete(adressId)
        sessionFactory.currentSession.flush()

        then:
        adressService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Adress adress = new Adress()
        adressService.save(adress)

        then:
        adress.id != null
    }
}
