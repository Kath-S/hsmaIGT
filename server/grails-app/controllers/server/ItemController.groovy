package server

import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class ItemController {

    ItemService itemService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]
    static scaffold = Item


}
