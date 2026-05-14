package com.usernotificationpreferencedeliveryapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.usernotificationpreferencedeliveryapi.entity.NotificationPreference;
import com.usernotificationpreferencedeliveryapi.entity.User;
import com.usernotificationpreferencedeliveryapi.enums.NotificationChannel;

public interface PreferenceRepository extends JpaRepository<NotificationPreference, Long> {

	Optional<NotificationPreference> findByUserAndChannel(User user, NotificationChannel channel);
}