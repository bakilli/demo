package bakil.demo.database;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AirportRepository extends MongoRepository<Airport, String> {
    Airport findByCity(String city);

}
