package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class WarehouseController {

    WarehouseService warehouseService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond warehouseService.list(params), model:[warehouseCount: warehouseService.count()]
    }

    def show(Long id) {
        respond warehouseService.get(id)
    }

    def create() {
        respond new Warehouse(params)
    }

    def save(Warehouse warehouse) {
        if (warehouse == null) {
            notFound()
            return
        }

        try {
            warehouseService.save(warehouse)
        } catch (ValidationException e) {
            respond warehouse.errors, view:'create'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'warehouse.label', default: 'Warehouse'), warehouse.id])
                redirect warehouse
            }
            '*' { respond warehouse, [status: CREATED] }
        }
    }

    def edit(Long id) {
        respond warehouseService.get(id)
    }

    def update(Warehouse warehouse) {
        if (warehouse == null) {
            notFound()
            return
        }

        try {
            warehouseService.save(warehouse)
        } catch (ValidationException e) {
            respond warehouse.errors, view:'edit'
            return
        }

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'warehouse.label', default: 'Warehouse'), warehouse.id])
                redirect warehouse
            }
            '*'{ respond warehouse, [status: OK] }
        }
    }

    def delete(Long id) {
        if (id == null) {
            notFound()
            return
        }

        warehouseService.delete(id)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'warehouse.label', default: 'Warehouse'), id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'warehouse.label', default: 'Warehouse'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
