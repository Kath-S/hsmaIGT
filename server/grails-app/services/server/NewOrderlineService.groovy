package server

import grails.gorm.services.Service

@Service(NewOrderline)
interface NewOrderlineService {

    NewOrderline get(Serializable id)

    List<NewOrderline> list(Map args)

    Long count()

    void delete(Serializable id)

    NewOrderline save(NewOrderline newOrderline)

}