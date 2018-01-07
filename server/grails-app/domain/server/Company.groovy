package server

class Company {

    String name
    String street
    String housenumber
    String postcode
    String country

    static hasMany = [partners: Partner, cutsomers: Customer, warehouses: Warehouse]

    static constraints = {
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
