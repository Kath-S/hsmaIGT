package server

class Adress {

    String street
    String housenumber
    String postcode
    String country
    static belongsTo = [district: District]

    static constraints = {
        street nullable: false
        housenumber nullable: false
        postcode nullable: false
        country nullable: false
        district nullable: true
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
