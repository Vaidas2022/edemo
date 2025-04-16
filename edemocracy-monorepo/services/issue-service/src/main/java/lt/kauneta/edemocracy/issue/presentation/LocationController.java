package lt.kauneta.edemocracy.issue.presentation;

import lt.kauneta.edemocracy.issue.dto.EldershipDto;
import lt.kauneta.edemocracy.issue.services.LocationService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService service;

    public LocationController(LocationService service) {
        this.service = service;
    }

    @GetMapping("/elderships")
    public List<EldershipDto> getAll() {
        return service.getAllElderships();
    }

    @GetMapping("/elderships/by-municipality/{code}")
    public List<EldershipDto> getByMunicipality(@PathVariable String code) {
        return service.getByMunicipality(code);
    }
}