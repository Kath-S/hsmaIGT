package server

class Partner {

    String name
    static belongsTo = [company: Company]


    static constraints = {
        company nullable: true
    }


    @Override
    public String toString() {
        return "Partner{" +
                "name='" + name + '\'' +
                '}';
    }
}
