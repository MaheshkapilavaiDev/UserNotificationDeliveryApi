package com.usernotificationpreferencedeliveryapi.dto;

import com.usernotificationpreferencedeliveryapi.enums.NotificationChannel;
import com.usernotificationpreferencedeliveryapi.enums.NotificationType;

public class NotificationRequestDTO {

	private Long userId;

	private String message;

	private NotificationChannel channel;

	private NotificationType type;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public NotificationChannel getChannel() {
		return channel;
	}

	public void setChannel(NotificationChannel channel) {
		this.channel = channel;
	}

	public NotificationType getType() {
		return type;
	}

	public void setType(NotificationType type) {
		this.type = type;
	}
	
	
}
