package server

class Customer {

    String firstname
    String lastname
    Adress  adresse
    static hasMany = [items: Item]
    static belongsTo = [company: Company]

    static constraints = {
        firstname nullable: false, blank: false
        lastname nullable: false, blank: false
        adresse nullable: false
        items nullable: true
        company nullable: true
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}
