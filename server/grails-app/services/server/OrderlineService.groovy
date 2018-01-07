package server

import grails.gorm.services.Service

@Service(Orderline)
interface OrderlineService {

    Orderline get(Serializable id)

    List<Orderline> list(Map args)

    Long count()

    void delete(Serializable id)

    Orderline save(Orderline orderline)

}