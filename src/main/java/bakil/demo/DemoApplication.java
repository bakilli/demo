package bakil.demo;

import bakil.demo.database.Flight;
import bakil.demo.database.FlightRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    private final FlightRepository repository;

    public DemoApplication(FlightRepository repository) {
        this.repository = repository;
    }
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    public void run(String... args) throws Exception {
        repository.deleteAll();

        repository.save(new Flight("MIA", "LAX", "2021-01-01", "2021-01-02", "100"));
        repository.save(new Flight("MIA", "LAX", "2021-01-01", "2021-01-02", "200"));

        System.out.println("Flights found with findAll():");
        System.out.println("-------------------------------");
        for (Flight flight : repository.findAll()) {
            System.out.println(flight);
        }
    }

}
