package bakil.demo.database;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Flight {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Id
    private String id;
    private String origin;
    private String destination;
    private String departureDate;
    private String returnDate;
    private String price;

    public Flight() {}

    public Flight(String origin, String destination, String departureDate, String returnDate, String price) {
        this.origin = origin;
        this.destination = destination;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(
                "Flights[id=%s, origin='%s', destination='%s', departureDate='%s', returnDate='%s', price='%s']",
                id, origin, destination, departureDate, returnDate, price);
    }
}
