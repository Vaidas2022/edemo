package lt.kauneta.edemocracy.auth.services;

import java.util.UUID;

import org.springframework.stereotype.Service;

import lt.kauneta.edemocracy.auth.models.User;
import lt.kauneta.edemocracy.auth.repository.UserRepository;
import lt.kauneta.edemocracy.issue.repository.EldershipRepository;

@Service
public class UserService {

	
	private final UserRepository userRepository;
	private final EldershipRepository eldershipRepository;
	
	
	

	public UserService(
			UserRepository userRepository, 
			EldershipRepository eldershipRepository
			) {

		this.userRepository = userRepository;
		this.eldershipRepository = eldershipRepository;
	}




	public void updateUserLocation(UUID userId, String eldershipCode) {
	    User user = userRepository.findById(userId)
	        .orElseThrow(() -> new RuntimeException("Vartotojas nerastas"));

	    var eldership = eldershipRepository.findByCode(eldershipCode)
	        .orElseThrow(() -> new RuntimeException("Seniūnija nerasta"));

	    user.setEldership(eldership); 
	    userRepository.save(user);
	}
}
