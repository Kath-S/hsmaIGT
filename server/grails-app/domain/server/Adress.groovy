package server

class Adress {

    String street
    String housenumber
    String postcode
    String country
    static belongsTo = [customer: Customer]

    static constraints = {
        customer(nullable:true)
    }


    @Override
    public String toString() {
        return "Adress{" +
                "street='" + street + '\'' +
                ", housenumber='" + housenumber + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
