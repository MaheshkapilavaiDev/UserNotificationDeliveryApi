package com.usernotificationpreferencedeliveryapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usernotificationpreferencedeliveryapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User save(User user);

}
