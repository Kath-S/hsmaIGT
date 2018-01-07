package server

class District {

    String name
    String number
    static hasMany = [adress: Adress]

    static constraints = {
    }


    @Override
    public String toString() {
        return "District{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
