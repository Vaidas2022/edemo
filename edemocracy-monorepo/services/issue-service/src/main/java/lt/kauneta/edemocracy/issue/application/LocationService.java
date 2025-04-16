package lt.kauneta.edemocracy.issue.application;

import java.util.List;

import org.springframework.stereotype.Service;

import lt.kauneta.edemocracy.issue.domain.EldershipRepository;
import lt.kauneta.edemocracy.issue.dto.EldershipDto;


@Service
public class LocationService {
	private final EldershipRepository eldershipRepository;
	


	public LocationService(EldershipRepository eldershipRepository) {
		this.eldershipRepository = eldershipRepository;
	}



	public List<EldershipDto> getByMunicipality(String code) {
	    return eldershipRepository.findByMunicipalityCode(code).stream()
	            .map(e -> new EldershipDto(e.getId(), e.getCode(), e.getName()))
	            .toList();
	}

	public List<EldershipDto> getAll() {
	    return eldershipRepository.findAll().stream()
	            .map(e -> new EldershipDto(e.getId(), e.getCode(), e.getName()))
	            .toList();
	}
}
