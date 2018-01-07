package server

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class NewOrderlineServiceSpec extends Specification {

    NewOrderlineService newOrderlineService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new NewOrderline(...).save(flush: true, failOnError: true)
        //new NewOrderline(...).save(flush: true, failOnError: true)
        //NewOrderline newOrderline = new NewOrderline(...).save(flush: true, failOnError: true)
        //new NewOrderline(...).save(flush: true, failOnError: true)
        //new NewOrderline(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //newOrderline.id
    }

    void "test get"() {
        setupData()

        expect:
        newOrderlineService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<NewOrderline> newOrderlineList = newOrderlineService.list(max: 2, offset: 2)

        then:
        newOrderlineList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        newOrderlineService.count() == 5
    }

    void "test delete"() {
        Long newOrderlineId = setupData()

        expect:
        newOrderlineService.count() == 5

        when:
        newOrderlineService.delete(newOrderlineId)
        sessionFactory.currentSession.flush()

        then:
        newOrderlineService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        NewOrderline newOrderline = new NewOrderline()
        newOrderlineService.save(newOrderline)

        then:
        newOrderline.id != null
    }
}
