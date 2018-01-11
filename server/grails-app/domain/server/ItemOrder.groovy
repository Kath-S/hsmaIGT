package server

class ItemOrder {

    static belongsTo = [item: Item, order: Order]



    static constraints = {
        item nullable: false
        order nullable: false
    }
}
