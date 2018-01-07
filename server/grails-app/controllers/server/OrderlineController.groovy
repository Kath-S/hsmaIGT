package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OrderlineController {

    OrderlineService orderlineService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond orderlineService.list(params), model:[orderlineCount: orderlineService.count()]
    }

    def show(Long id) {
        respond orderlineService.get(id)
    }

    def create() {
        respond new Orderline(params)
    }

    def save(Orderline orderline) {
        if (orderline == null) {
            notFound()
            return
        }

        try {
            orderlineService.save(orderline)
        } catch (ValidationException e) {
            respond orderline.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'orderline.label', default: 'Orderline'), orderline.id])
                redirect orderline
            }
            '*' { respond orderline, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond orderlineService.get(id)
    }

    def update(Orderline orderline) {
        if (orderline == null) {
            notFound()
            return
        }

        try {
            orderlineService.save(orderline)
        } catch (ValidationException e) {
            respond orderline.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'orderline.label', default: 'Orderline'), orderline.id])
                redirect orderline
            }
            '*'{ respond orderline, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        orderlineService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'orderline.label', default: 'Orderline'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'orderline.label', default: 'Orderline'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
