package server

class Warehouse {

    String name
    static hasMany = [districts: District]
    static belongsTo = [company: Company]

    static constraints = {
        name nullable: false, blank: false
        districts nullable: true
        company nullable: true

    }
}
