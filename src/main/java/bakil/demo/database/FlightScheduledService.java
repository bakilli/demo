package bakil.demo.database;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class FlightScheduledService {
    private final FlightRepository repository;

    public FlightScheduledService(FlightRepository repository) {
        this.repository = repository;
    }

    @Scheduled(fixedRate = 10000)
    public void requestAndSaveFlights() {
        Flight flight = new Flight();
        flight.setOrigin(getRandomString(3));
        flight.setDestination(getRandomString(3));
        flight.setDepartureDate(getRandomDate());
        flight.setReturnDate(getRandomDate());
        flight.setPrice(String.valueOf(new Random().nextInt(999) + 1));
        repository.save(flight);
        System.out.println("Saved flight: " + flight);
    }

    private String getRandomString(int length) {
        return new Random().ints(65, 91)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    private String getRandomDate() {
        int month = new Random().nextInt(12) + 1;
        int day = new Random().nextInt(28) + 1;
        return String.format("2024-%02d-%02d", month, day);
    }
}
