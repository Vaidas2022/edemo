package lt.kauneta.edemocracy.issue.controllers;

import lt.kauneta.edemocracy.issue.dto.CountyDto;
import lt.kauneta.edemocracy.issue.dto.EldershipDto;
import lt.kauneta.edemocracy.issue.dto.MunicipalityDto;
import lt.kauneta.edemocracy.issue.services.LocationService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

	    private final LocationService locationService;

	    public LocationController(LocationService locationService) {
	        this.locationService = locationService;
	    }

	    @GetMapping("/counties")
	    public List<CountyDto> getAllCounties() {
	        return locationService.getAllCounties();
	    }

	    @GetMapping("/municipalities/by-county/{code}")
	    public List<MunicipalityDto> getMunicipalitiesByCounty(@PathVariable String code) {
	        return locationService.getMunicipalitiesByCounty(code);
	    }

	    @GetMapping("/elderships/by-municipality/{code}")
	    public List<EldershipDto> getEldershipsByMunicipality(@PathVariable String code) {
	        return locationService.getByMunicipality(code);
	    }

	    @GetMapping("/elderships")
	    public List<EldershipDto> getAllElderships() {
	        return locationService.getAllElderships();
	    }
}