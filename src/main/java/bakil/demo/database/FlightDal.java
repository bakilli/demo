package bakil.demo.database;

import org.springframework.stereotype.Service;

@Service
public class FlightDal {
    private final FlightRepository repository;

    public FlightDal(FlightRepository repository) {
        this.repository = repository;
    }

    public void save(Flight flight) {
        repository.save(flight);
    }

    public void delete(Flight flight) {
        repository.delete(flight);
    }

    public void deleteAll() {
        repository.deleteAll();
    }

    public Iterable<Flight> findAll() {
        return repository.findAll();
    }

    public Flight findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Iterable<Flight> findByOrigin(String origin) {
        return repository.findByOrigin(origin);
    }

    public Iterable<Flight> findByDestination(String destination) {
        return repository.findByDestination(destination);
    }

    public Iterable<Flight> findByDepartureDate(String departureDate) {
        return repository.findByDepartureDate(departureDate);
    }

    public Iterable<Flight> findByReturnDate(String returnDate) {
        return repository.findByReturnDate(returnDate);
    }

    public Iterable<Flight> findByPrice(String price) {
        return repository.findByPrice(price);
    }
}
