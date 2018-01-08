package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OrderlineController {

    OrderlineService orderlineService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static scaffold = Orderline


}
