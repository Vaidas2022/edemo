package lt.kauneta.edemocracy.auth.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lt.kauneta.edemocracy.auth.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	private final UserService userService;

	
	
}
