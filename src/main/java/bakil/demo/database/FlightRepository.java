package bakil.demo.database;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FlightRepository extends MongoRepository<Flight, String> {
}
