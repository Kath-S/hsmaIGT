package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class NewOrderlineController {

    NewOrderlineService newOrderlineService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond newOrderlineService.list(params), model:[newOrderlineCount: newOrderlineService.count()]
    }

    def show(Long id) {
        respond newOrderlineService.get(id)
    }

    def create() {
        respond new NewOrderline(params)
    }

    def save(NewOrderline newOrderline) {
        if (newOrderline == null) {
            notFound()
            return
        }

        try {
            newOrderlineService.save(newOrderline)
        } catch (ValidationException e) {
            respond newOrderline.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'newOrderline.label', default: 'NewOrderline'), newOrderline.id])
                redirect newOrderline
            }
            '*' { respond newOrderline, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond newOrderlineService.get(id)
    }

    def update(NewOrderline newOrderline) {
        if (newOrderline == null) {
            notFound()
            return
        }

        try {
            newOrderlineService.save(newOrderline)
        } catch (ValidationException e) {
            respond newOrderline.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'newOrderline.label', default: 'NewOrderline'), newOrderline.id])
                redirect newOrderline
            }
            '*'{ respond newOrderline, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        newOrderlineService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'newOrderline.label', default: 'NewOrderline'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'newOrderline.label', default: 'NewOrderline'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
