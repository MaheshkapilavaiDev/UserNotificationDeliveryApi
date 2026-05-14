package com.usernotificationpreferencedeliveryapi.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import com.usernotificationpreferencedeliveryapi.dto.NotificationRequestDTO;
import com.usernotificationpreferencedeliveryapi.entity.NotificationHistory;
import com.usernotificationpreferencedeliveryapi.entity.NotificationPreference;
import com.usernotificationpreferencedeliveryapi.entity.User;
import com.usernotificationpreferencedeliveryapi.enums.NotificationStatus;
import com.usernotificationpreferencedeliveryapi.enums.NotificationType;
import com.usernotificationpreferencedeliveryapi.exception.UserNotFoundException;
import com.usernotificationpreferencedeliveryapi.repository.NotificationRepository;
import com.usernotificationpreferencedeliveryapi.repository.PreferenceRepository;
import com.usernotificationpreferencedeliveryapi.repository.UserRepository;

@Slf4j
@Service
public class NotificationService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PreferenceRepository preferenceRepository;

	@Autowired
	private NotificationRepository notificationRepository;

	public String sendNotification(NotificationRequestDTO dto) {

		//Log.info("Recived Notification request for User ID:{}", dto.getUserId());

		User user = userRepository.findById(dto.getUserId())
				.orElseThrow(() -> new UserNotFoundException("User not found"));

		boolean enabled = preferenceRepository.findByUserAndChannel(user, dto.getChannel())
				.map(NotificationPreference::isEnabled).orElse(false);

		NotificationHistory history = new NotificationHistory();

		history.setUser(user);
		history.setMessage(dto.getMessage());
		history.setChannel(dto.getChannel());
		history.setType(dto.getType());
		history.setSentAt(LocalDateTime.now());

		if (enabled) {

			history.setStatus(NotificationStatus.SENT);

			notificationRepository.save(history);

			return "Notification Sent Successfully";
		} else {

			history.setStatus(NotificationStatus.FAILED);

			notificationRepository.save(history);

			return "Channel Disabled. Notification Failed";
		}
	}

	public List<NotificationHistory> getByUser(Long userId) {

		return notificationRepository.findByUserId(userId);
	}

	public List<NotificationHistory> getByStatus(NotificationStatus status) {

		return notificationRepository.findByStatus(status);
	}

	public List<NotificationHistory> getByType(NotificationType type) {

		return notificationRepository.findByType(type);
	}
}
