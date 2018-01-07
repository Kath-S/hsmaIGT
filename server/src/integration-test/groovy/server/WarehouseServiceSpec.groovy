package server

import grails.testing.mixin.integration.Integration
import grails.gorm.transactions.Rollback
import spock.lang.Specification
import org.hibernate.SessionFactory

@Integration
@Rollback
class WarehouseServiceSpec extends Specification {

    WarehouseService warehouseService
    SessionFactory sessionFactory

    private Long setupData() {
        // TODO: Populate valid domain instances and return a valid ID
        //new Warehouse(...).save(flush: true, failOnError: true)
        //new Warehouse(...).save(flush: true, failOnError: true)
        //Warehouse warehouse = new Warehouse(...).save(flush: true, failOnError: true)
        //new Warehouse(...).save(flush: true, failOnError: true)
        //new Warehouse(...).save(flush: true, failOnError: true)
        assert false, "TODO: Provide a setupData() implementation for this generated test suite"
        //warehouse.id
    }

    void "test get"() {
        setupData()

        expect:
        warehouseService.get(1) != null
    }

    void "test list"() {
        setupData()

        when:
        List<Warehouse> warehouseList = warehouseService.list(max: 2, offset: 2)

        then:
        warehouseList.size() == 2
        assert false, "TODO: Verify the correct instances are returned"
    }

    void "test count"() {
        setupData()

        expect:
        warehouseService.count() == 5
    }

    void "test delete"() {
        Long warehouseId = setupData()

        expect:
        warehouseService.count() == 5

        when:
        warehouseService.delete(warehouseId)
        sessionFactory.currentSession.flush()

        then:
        warehouseService.count() == 4
    }

    void "test save"() {
        when:
        assert false, "TODO: Provide a valid instance to save"
        Warehouse warehouse = new Warehouse()
        warehouseService.save(warehouse)

        then:
        warehouse.id != null
    }
}
