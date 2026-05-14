package com.usernotificationpreferencedeliveryapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usernotificationpreferencedeliveryapi.entity.User;

import com.usernotificationpreferencedeliveryapi.entity.NotificationPreference;
import com.usernotificationpreferencedeliveryapi.enums.NotificationChannel;
import com.usernotificationpreferencedeliveryapi.exception.UserNotFoundException;
import com.usernotificationpreferencedeliveryapi.repository.PreferenceRepository;
import com.usernotificationpreferencedeliveryapi.repository.UserRepository;

@Service
public class PreferenceService {

	@Autowired
	private PreferenceRepository preferenceRepository;

	@Autowired
	private UserRepository userRepository;

	public NotificationPreference updatePreference(Long userId, NotificationChannel channel, boolean enabled) {

		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

		NotificationPreference preference = preferenceRepository.findByUserAndChannel(user, channel)
				.orElseThrow(() -> new UserNotFoundException("Preference not found"));

		preference.setEnabled(enabled);

		return preferenceRepository.save(preference);
	}

	public List<NotificationPreference> getPreferences(Long userId) {

		User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User not found"));

		return preferenceRepository.findAll().stream().filter(p -> p.getUser().getId().equals(user.getId())).toList();
	}
}