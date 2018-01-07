package server

import grails.gorm.services.Service

@Service(Adress)
interface AdressService {

    Adress get(Serializable id)

    List<Adress> list(Map args)

    Long count()

    void delete(Serializable id)

    Adress save(Adress adress)

}