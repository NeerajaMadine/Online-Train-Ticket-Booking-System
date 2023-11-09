package com.Anudip.TrainTicketReservationSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Anudip.TrainTicketReservationSystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long>  {
	@Query("SELECT u from User u WHERE u.email = ?1")
	User findUserByEmail(String email);
	List<User> searchUsers(String criteria);
	

}
