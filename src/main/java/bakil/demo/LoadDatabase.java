package bakil.demo;

import bakil.demo.database.Flight;
import bakil.demo.database.FlightRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    // add dummy data
    @Bean
    CommandLineRunner initDatabase(FlightRepository repository) {
        return args -> {
            repository.deleteAll();
            repository.save(new Flight("MIA", "LAX", "2024-01-01", "2024-01-15", "100"));
            repository.save(new Flight("MIA", "LAX", "2024-01-01", "2024-01-13", "200"));
        };
    }

}
