package lt.kauneta.edemocracy.issue.services;

import java.util.List;

import org.springframework.stereotype.Service;

import lt.kauneta.edemocracy.issue.dto.CountyDto;
import lt.kauneta.edemocracy.issue.dto.EldershipDto;
import lt.kauneta.edemocracy.issue.dto.MunicipalityDto;
import lt.kauneta.edemocracy.issue.repository.CountyRepository;
import lt.kauneta.edemocracy.issue.repository.EldershipRepository;
import lt.kauneta.edemocracy.issue.repository.MunicipalityRepository;


@Service
public class LocationService {
	private final CountyRepository countyRepository;
    private final MunicipalityRepository municipalityRepository;
    private final EldershipRepository eldershipRepository;

    public LocationService(
        CountyRepository countyRepository,
        MunicipalityRepository municipalityRepository,
        EldershipRepository eldershipRepository
    ) {
        this.countyRepository = countyRepository;
        this.municipalityRepository = municipalityRepository;
        this.eldershipRepository = eldershipRepository;
    }

    public List<CountyDto> getAllCounties() {
        return countyRepository.findAll().stream()
                .map(c -> new CountyDto(c.getId(), c.getCode(), c.getName()))
                .toList();
    }

    public List<MunicipalityDto> getMunicipalitiesByCounty(String countyCode) {
        return municipalityRepository.findByCountyCode(countyCode).stream()
                .map(m -> new MunicipalityDto(
                        m.getId(),
                        m.getCode(),
                        m.getName(),
                        m.getCounty().getCode()
                ))
                .toList();
    }

    public List<EldershipDto> getByMunicipality(String code) {
        return eldershipRepository.findByMunicipalityCode(code).stream()
                .map(e -> new EldershipDto(
                        e.getId(),
                        e.getCode(),
                        e.getName(),
                        e.getMunicipality().getCode()
                ))
                .toList();
    }
    
    
	public List<EldershipDto> getAllElderships() {
        return eldershipRepository.findAll().stream()
                .map(e -> new EldershipDto(
                        e.getId(),
                        e.getCode(),
                        e.getName(),
                        e.getMunicipality().getCode()
                ))
                .toList();
    }
}
