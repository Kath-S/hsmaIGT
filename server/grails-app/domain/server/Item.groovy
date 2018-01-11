package server

class Item {

    String producttype
    String name
    static belongsTo = [customer: Customer]
    static hasMany = [itemOrder: ItemOrder]



    static constraints = {
        name nullable: false, blank: false
        itemOrder nullable: true
        customer nullable: true
    }


    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
