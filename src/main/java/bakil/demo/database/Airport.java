package bakil.demo.database;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Airport {

    @Id
    private String id;
    private String city;

    public Airport() {
    }

    public Airport(String city) {
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Airport{" +
                "id='" + id + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
