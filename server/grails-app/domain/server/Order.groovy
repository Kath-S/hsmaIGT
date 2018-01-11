package server

class Order {

    Date createdAt
    static hasMany = [itemOrder: ItemOrder]
    static belongsTo = [orderline: Orderline, newOrderline: NewOrderline]

    static constraints = {
        itemOrder nullable: true
        orderline nullable: true
        newOrderline nullable: true

    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                '}';
    }
}
