package com.Anudip.TrainTicketReservationSystem.Service;

import java.util.List;
import java.util.Set;

import com.Anudip.TrainTicketReservationSystem.entity.User;
public interface UserService {

    // Create a new user
    User createUser(User user);

    // Retrieve a user by ID
    User getUserById(Long userId);

    // Retrieve a user by email
    User getUserByEmail(String email);

    // Update user information
    User updateUser(User user);

    // Delete a user by ID
    void deleteUser(Long userId);

    // Get a list of all users
    List<User> getAllUsers();
    
 // Add a role to a user
    void addUserRole(User user, String role);

    // Remove a role from a user
    void removeUserRole(User user, String role);

    // Check if a user has a specific role
    boolean hasRole(User user, String role);

    // Change a user's password
    void changePassword(User user, String newPassword);

    // Search for users by a specific criterion (e.g., name, email, etc.)
    List<User> searchUsers(String criteria);

    // Lock or unlock a user's account
    void lockUserAccount(User user);
    void unlockUserAccount(User user);

    // Retrieve the user's role(s)
    Set<String> getUserRoles(User user);

}
