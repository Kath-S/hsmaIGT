package server

class Item {

    String producttype
    String name



    static constraints = {
    }


    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                '}';
    }
}
