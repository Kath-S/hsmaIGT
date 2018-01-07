package server

class Order {

    Date createdAt
    static hasMany = [items: Item]

    static constraints = {
    }
}
