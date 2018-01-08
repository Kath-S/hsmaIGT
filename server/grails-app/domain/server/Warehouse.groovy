package server

class Warehouse {

    String name
    static hasMany = [districts: District]
    static belongsTo = [company: Company]

    static constraints = {
    }
}
