package server

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class OrderlineServiceSpec extends Specification {

    OrderlineService orderlineService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Orderline(...).save(flush: true, failOnError: true)
        //new Orderline(...).save(flush: true, failOnError: true)
        //Orderline orderline = new Orderline(...).save(flush: true, failOnError: true)
        //new Orderline(...).save(flush: true, failOnError: true)
        //new Orderline(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //orderline.id
    }

    void "test get"() {
        setupData()

        expect:
        orderlineService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Orderline> orderlineList = orderlineService.list(max: 2, offset: 2)

        then:
        orderlineList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        orderlineService.count() == 5
    }

    void "test delete"() {
        Long orderlineId = setupData()

        expect:
        orderlineService.count() == 5

        when:
        orderlineService.delete(orderlineId)
        sessionFactory.currentSession.flush()

        then:
        orderlineService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Orderline orderline = new Orderline()
        orderlineService.save(orderline)

        then:
        orderline.id != null
    }
}
