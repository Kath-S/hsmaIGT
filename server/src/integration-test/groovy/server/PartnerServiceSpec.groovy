package server

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class PartnerServiceSpec extends Specification {

    PartnerService partnerService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Partner(...).save(flush: true, failOnError: true)
        //new Partner(...).save(flush: true, failOnError: true)
        //Partner partner = new Partner(...).save(flush: true, failOnError: true)
        //new Partner(...).save(flush: true, failOnError: true)
        //new Partner(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //partner.id
    }

    void "test get"() {
        setupData()

        expect:
        partnerService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Partner> partnerList = partnerService.list(max: 2, offset: 2)

        then:
        partnerList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        partnerService.count() == 5
    }

    void "test delete"() {
        Long partnerId = setupData()

        expect:
        partnerService.count() == 5

        when:
        partnerService.delete(partnerId)
        sessionFactory.currentSession.flush()

        then:
        partnerService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Partner partner = new Partner()
        partnerService.save(partner)

        then:
        partner.id != null
    }
}
