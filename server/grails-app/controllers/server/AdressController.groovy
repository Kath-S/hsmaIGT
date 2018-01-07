package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AdressController {

    AdressService adressService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond adressService.list(params), model:[adressCount: adressService.count()]
    }

    def show(Long id) {
        respond adressService.get(id)
    }

    def create() {
        respond new Adress(params)
    }

    def save(Adress adress) {
        if (adress == null) {
            notFound()
            return
        }

        try {
            adressService.save(adress)
        } catch (ValidationException e) {
            respond adress.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'adress.label', default: 'Adress'), adress.id])
                redirect adress
            }
            '*' { respond adress, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond adressService.get(id)
    }

    def update(Adress adress) {
        if (adress == null) {
            notFound()
            return
        }

        try {
            adressService.save(adress)
        } catch (ValidationException e) {
            respond adress.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'adress.label', default: 'Adress'), adress.id])
                redirect adress
            }
            '*'{ respond adress, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        adressService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'adress.label', default: 'Adress'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'adress.label', default: 'Adress'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
