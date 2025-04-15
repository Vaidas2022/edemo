package lt.kauneta.edemocracy.issue.dto;

import java.util.UUID;

public record IssueDto(UUID id, String title, String description) {}
