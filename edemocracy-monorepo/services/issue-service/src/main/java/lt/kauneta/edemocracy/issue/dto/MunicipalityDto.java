package lt.kauneta.edemocracy.issue.dto;

import java.util.UUID;

public record MunicipalityDto(UUID id, String code, String name, String countyCode) {}
