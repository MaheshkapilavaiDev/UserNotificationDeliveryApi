package com.usernotificationpreferencedeliveryapi.dto;

import com.usernotificationpreferencedeliveryapi.enums.NotificationChannel;

public class PreferenceDTO {

	private NotificationChannel channel;
	private boolean enabled;
	
	public NotificationChannel getChannel() {
		return channel;
	}
	public void setChannel(NotificationChannel channel) {
		this.channel = channel;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
