package bakil.demo.database;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightRepository repository;
    private final AirportRepository airportRepository;

    FlightController(FlightRepository repository, AirportRepository airportRepository) {
        this.repository = repository;
        this.airportRepository = airportRepository;
    }

    @GetMapping("/getall")
    List<Flight> all() {
        return repository.findAll();
    }

    @GetMapping("/get/{id}")
    Optional<Flight> getFlight(@PathVariable String id) {
        return repository.findById(id);
    }


    @PostMapping("/create")
    Flight newFlight(@RequestBody Flight newFlight) {
        // if the origin airport doesn't exist, break
        if (airportRepository.findByCity(newFlight.getOrigin()) == null) {
            return null;
        }
        // if the destination airport doesn't exist, break
        if (airportRepository.findByCity(newFlight.getDestination()) == null) {
            return null;
        }
        return repository.save(newFlight);
    }

    @PutMapping("/search")
    List<Flight> searchFlights(@RequestBody Flight newFlight) {
        List<Flight> flights = new ArrayList<>();
        for (Flight flight : repository.findAll()) {
            if (flight.getOrigin().equals(newFlight.getOrigin()) ||
                    flight.getDestination().equals(newFlight.getDestination()) ||
                    flight.getDepartureDate().equals(newFlight.getDepartureDate()) ||
                    flight.getReturnDate().equals(newFlight.getReturnDate())) {
                flights.add(flight);
            }
        }
        return flights;
    }

    @PutMapping("/update/{id}")
    Flight replaceFlight(@RequestBody Flight newFlight, @PathVariable String id) {
        return repository.findById(id)
                .map(flight -> {
                    flight.setOrigin(newFlight.getOrigin());
                    flight.setDestination(newFlight.getDestination());
                    flight.setDepartureDate(newFlight.getDepartureDate());
                    flight.setReturnDate(newFlight.getReturnDate());
                    flight.setPrice(newFlight.getPrice());
                    return repository.save(flight);
                })
                .orElseGet(() -> {
                    newFlight.setId(id);
                    return repository.save(newFlight);
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteFlight(@PathVariable String id) {
        repository.deleteById(id);
    }
}
