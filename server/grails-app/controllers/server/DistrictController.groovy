package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class DistrictController {

    DistrictService districtService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static scaffold = District


}
