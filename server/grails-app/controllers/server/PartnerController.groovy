package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PartnerController {

    PartnerService partnerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond partnerService.list(params), model:[partnerCount: partnerService.count()]
    }

    def show(Long id) {
        respond partnerService.get(id)
    }

    def create() {
        respond new Partner(params)
    }

    def save(Partner partner) {
        if (partner == null) {
            notFound()
            return
        }

        try {
            partnerService.save(partner)
        } catch (ValidationException e) {
            respond partner.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'partner.label', default: 'Partner'), partner.id])
                redirect partner
            }
            '*' { respond partner, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond partnerService.get(id)
    }

    def update(Partner partner) {
        if (partner == null) {
            notFound()
            return
        }

        try {
            partnerService.save(partner)
        } catch (ValidationException e) {
            respond partner.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'partner.label', default: 'Partner'), partner.id])
                redirect partner
            }
            '*'{ respond partner, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        partnerService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'partner.label', default: 'Partner'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'partner.label', default: 'Partner'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
