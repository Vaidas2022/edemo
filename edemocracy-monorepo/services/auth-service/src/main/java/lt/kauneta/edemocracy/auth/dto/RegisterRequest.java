package lt.kauneta.edemocracy.auth.dto;

public record RegisterRequest(String loginName, String password, String role) {}