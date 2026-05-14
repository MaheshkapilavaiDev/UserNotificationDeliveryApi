package com.usernotificationpreferencedeliveryapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.usernotificationpreferencedeliveryapi.dto.NotificationRequestDTO;
import com.usernotificationpreferencedeliveryapi.dto.ResponseDTO;
import com.usernotificationpreferencedeliveryapi.entity.NotificationHistory;
import com.usernotificationpreferencedeliveryapi.enums.NotificationStatus;
import com.usernotificationpreferencedeliveryapi.enums.NotificationType;
import com.usernotificationpreferencedeliveryapi.service.NotificationService;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

	@Autowired
	private NotificationService notificationService;

	@PostMapping("/send")
	public ResponseDTO sendNotification(@RequestBody NotificationRequestDTO dto) {

		return new ResponseDTO(notificationService.sendNotification(dto));
	}

	@GetMapping("/user/{userId}")
	public List<NotificationHistory> getByUser(@PathVariable Long userId) {

		return notificationService.getByUser(userId);
	}

	@GetMapping("/status/{status}")
	public List<NotificationHistory> getByStatus(@PathVariable NotificationStatus status) {

		return notificationService.getByStatus(status);
	}

	@GetMapping("/type/{type}")
	public List<NotificationHistory> getByType(@PathVariable NotificationType type) {

		return notificationService.getByType(type);
	}
}
