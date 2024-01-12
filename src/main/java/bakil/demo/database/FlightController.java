package bakil.demo.database;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flights")
public class FlightController {

    private final FlightRepository repository;

    FlightController(FlightRepository repository) {
        this.repository = repository;
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
        return repository.save(newFlight);
    }

    @GetMapping("/search")
    List<Flight> searchFlights(@RequestParam String origin, @RequestParam String destination, @RequestParam String departureDate, @RequestParam(required = false) String returnDate) {
        if (returnDate == null) {
            return repository.findByOriginAndDestinationAndDepartureDate(origin, destination, departureDate);
        } else {
            return repository.findByOriginAndDestinationAndDepartureDateAndReturnDate(origin, destination, departureDate, returnDate);
        }
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
