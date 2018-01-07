package server

class Adress {

    String street
    String housenumber
    String postcode
    String country

    static constraints = {
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
