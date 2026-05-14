package com.usernotificationpreferencedeliveryapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usernotificationpreferencedeliveryapi.entity.NotificationHistory;
import com.usernotificationpreferencedeliveryapi.enums.NotificationStatus;
import com.usernotificationpreferencedeliveryapi.enums.NotificationType;

@Repository
public interface NotificationRepository extends JpaRepository<NotificationHistory, Long> {

	List<NotificationHistory> findByUserId(Long userId);

	List<NotificationHistory> findByStatus(NotificationStatus status);

	List<NotificationHistory> findByType(NotificationType type);

}
