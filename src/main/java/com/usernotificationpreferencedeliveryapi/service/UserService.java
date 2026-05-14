package com.usernotificationpreferencedeliveryapi.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usernotificationpreferencedeliveryapi.entity.NotificationPreference;
import com.usernotificationpreferencedeliveryapi.entity.User;
import com.usernotificationpreferencedeliveryapi.enums.NotificationChannel;
import com.usernotificationpreferencedeliveryapi.repository.PreferenceRepository;
import com.usernotificationpreferencedeliveryapi.repository.UserRepository;

@Service
//@RequiredArgsConstructor
public class UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PreferenceRepository preferenceRepository;

	public User createUser(User user) {

		User savedUser = userRepository.save(user);

		Arrays.stream(NotificationChannel.values()).forEach(channel -> {

			NotificationPreference preference = new NotificationPreference();

			preference.setUser(savedUser);
			preference.setChannel(channel);
			preference.setEnabled(false);

			preferenceRepository.save(preference);
		});

		return savedUser;
	}

	public User getUser(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
}
