package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class NewOrderlineController {

    NewOrderlineService newOrderlineService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static scaffold = NewOrderline


}
