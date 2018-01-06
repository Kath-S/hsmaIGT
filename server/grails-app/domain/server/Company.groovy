package server

class Company {

    String name
    String street
    Street housenumber
    String postcode
    String country

    static hasMany = [partners: Partner]

    static constraints = {
    }
}
