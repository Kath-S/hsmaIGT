package server

class District {

    String name
    String number
    static hasMany = [adress: Adress]
    static belongsTo = [warehouse: Warehouse]

    static constraints = {
        name nullable: false, blank: false
        number nullable: false, blank: false
        adress nullable: true
        warehouse nullable: true
    }


    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
