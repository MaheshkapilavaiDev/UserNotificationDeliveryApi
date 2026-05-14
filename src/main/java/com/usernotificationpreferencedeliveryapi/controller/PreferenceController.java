package com.usernotificationpreferencedeliveryapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.usernotificationpreferencedeliveryapi.entity.NotificationPreference;
import com.usernotificationpreferencedeliveryapi.enums.NotificationChannel;
import com.usernotificationpreferencedeliveryapi.service.PreferenceService;

@RestController
@RequestMapping("/preferences")
public class PreferenceController {

	@Autowired
	private PreferenceService preferenceService;

	@PutMapping("/{userId}")
	public NotificationPreference updatePreference(@PathVariable Long userId, @RequestParam NotificationChannel channel,
			@RequestParam boolean enabled) {

		return preferenceService.updatePreference(userId, channel, enabled);
	}

	@GetMapping("/{userId}")
	public List<NotificationPreference> getPreferences(@PathVariable Long userId) {

		return preferenceService.getPreferences(userId);
	}
}
