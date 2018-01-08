package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class CustomerController {

    CustomerService customerService


    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static scaffold = Customer


}
