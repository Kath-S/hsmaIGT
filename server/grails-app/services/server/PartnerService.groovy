package server

import grails.gorm.services.Service

@Service(Partner)
interface PartnerService {

    Partner get(Serializable id)

    List<Partner> list(Map args)

    Long count()

    void delete(Serializable id)

    Partner save(Partner partner)

}