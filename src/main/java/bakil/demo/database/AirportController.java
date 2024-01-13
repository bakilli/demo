package bakil.demo.database;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/airports")
public class AirportController {
    private final AirportRepository repository;

    AirportController(AirportRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/getall")
    List<Airport> all() {
        return repository.findAll();
    }

    @GetMapping("/get/{id}")
    Optional<Airport> getAirport(@PathVariable String id) {
        return repository.findById(id);
    }

    @PostMapping("/create")
    Airport newAirport(@RequestBody Airport newAirport) {
        return repository.save(newAirport);
    }

    @PutMapping("/update/{id}")
    Airport replaceAirport(@RequestBody Airport newAirport, @PathVariable String id) {
        return repository.findById(id)
                .map(airport -> {
                    airport.setCity(newAirport.getCity());
                    return repository.save(airport);
                })
                .orElseGet(() -> {
                    newAirport.setId(id);
                    return repository.save(newAirport);
                });
    }

    @DeleteMapping("/delete/{id}")
    void deleteAirport(@PathVariable String id) {
        repository.deleteById(id);
    }
}
