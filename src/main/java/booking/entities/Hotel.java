package booking.entities;

public class Hotel {
    private String name;
    private String price;

    public Hotel(String price) {
       this.price = price;
    }

    public Hotel() {
        super();
    }

    public String getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
}
