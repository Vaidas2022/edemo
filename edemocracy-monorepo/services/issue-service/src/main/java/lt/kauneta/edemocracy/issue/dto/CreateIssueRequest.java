package lt.kauneta.edemocracy.issue.dto;

import java.util.UUID;

public record CreateIssueRequest(String title, String description, UUID eldershipId) {}