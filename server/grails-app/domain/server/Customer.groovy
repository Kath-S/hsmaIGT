package server

class Customer {

    String firstname
    String lastname
    static hasOne = [adress: Adress]
    static hasMany = [items: Item]

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
