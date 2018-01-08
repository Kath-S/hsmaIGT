package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class WarehouseController {

    WarehouseService warehouseService


    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static scaffold = Warehouse


}
