package server

import grails.gorm.services.Service

@Service(Warehouse)
interface WarehouseService {

    Warehouse get(Serializable id)

    List<Warehouse> list(Map args)

    Long count()

    void delete(Serializable id)

    Warehouse save(Warehouse warehouse)

}