package bakil.demo.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FlightRepository extends MongoRepository<Flight, String> {

    // Query
    List<Flight> findByOrigin(String origin);
    List<Flight> findByDestination(String destination);
    List<Flight> findByDepartureDate(String departureDate);
    List<Flight> findByReturnDate(String returnDate);
    List<Flight> findByPrice(String price);

    List<Flight> findByOriginAndDestinationAndDepartureDate(String origin, String destination, String departureDate);

    List<Flight> findByOriginAndDestinationAndDepartureDateAndReturnDate(String origin, String destination, String departureDate, String returnDate);
}
