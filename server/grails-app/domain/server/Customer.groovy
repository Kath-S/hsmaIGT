package server

class Customer {

    String firstname
    String lastname
    Adress  adresse
    static hasMany = [items: Item]
    static belongsTo = [company: Company]

    static constraints = {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
