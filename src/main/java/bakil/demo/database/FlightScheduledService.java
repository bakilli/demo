package bakil.demo.database;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class FlightScheduledService {
    private final FlightRepository repository;
    private final AirportRepository airportRepository;

    public FlightScheduledService(FlightRepository repository, AirportRepository airportRepository) {
        this.repository = repository;
        this.airportRepository = airportRepository;
    }

    @Scheduled(fixedRate = 10000)
    public void requestAndSaveFlights() {
        Flight flight = getRandomFlight();
        repository.save(flight);
        System.out.println("Saved flight: " + flight);
    }

    private String getRandomAirport() {
        List<Airport> airports = airportRepository.findAll();
        return airports.get(new Random().nextInt(airports.size())).getCity();
    }

    private String getRandomDate() {
        int month = new Random().nextInt(12) + 1;
        int day = new Random().nextInt(28) + 1;
        return String.format("2024-%02d-%02d", month, day);
    }

    private Flight getRandomFlight() {
        Flight flight = new Flight();
        flight.setOrigin(getRandomAirport());
        flight.setDestination(getRandomAirport());
        while (flight.getOrigin().equals(flight.getDestination())) {
            flight.setDestination(getRandomAirport());
        }
        flight.setDepartureDate(getRandomDate());
        flight.setReturnDate(getRandomDate());
        flight.setPrice(String.valueOf(new Random().nextInt(999) + 1));
        return flight;
    }
}
