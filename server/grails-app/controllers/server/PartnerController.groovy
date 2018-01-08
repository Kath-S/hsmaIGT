package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class PartnerController {

    PartnerService partnerService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static scaffold = Partner



}
