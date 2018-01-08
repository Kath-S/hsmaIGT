package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class AdressController {

    AdressService adressService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static scaffold = Adress


}
