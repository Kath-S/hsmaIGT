package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class OrderController {

    OrderService orderService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static scaffold = Order


}
