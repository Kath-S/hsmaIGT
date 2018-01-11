package server

class Company {

    String name
    Adress adress

    static hasMany = [partners: Partner, customers: Customer, warehouses: Warehouse]

    static constraints = {
        adress nullable: false
        partners nullable: true
        customers nullable: true
        warehouses nullable: true
    }


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                '}';
    }
}
