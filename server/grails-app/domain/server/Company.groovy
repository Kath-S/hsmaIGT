package server

class Company {

    String name
    String street
    String housenumber
    String postcode
    String country

    static hasMany = [partners: Partner, customers: Customer, warehouses: Warehouse]

    static constraints = {
        partners nullable: true
        customers nullable: true
        warehouses nullable: true
    }


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", housenumber='" + housenumber + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
