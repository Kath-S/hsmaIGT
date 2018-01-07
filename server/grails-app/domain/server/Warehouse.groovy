package server

class Warehouse {

    String name
    static hasMany = [districts: District]

    static constraints = {
    }
}
