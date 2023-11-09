package com.Anudip.TrainTicketReservationSystem.UserServiceImpl;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Anudip.TrainTicketReservationSystem.Service.UserService;
import com.Anudip.TrainTicketReservationSystem.entity.User;
import com.Anudip.TrainTicketReservationSystem.Repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        // Implement the logic to create a new user
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        // Implement the logic to retrieve a list of all users
        return userRepository.findAll();
    }

    @Override
    public void changePassword(User user, String newPassword) {
        // Implement the logic to change a user's password
        user.setPassword(newPassword);
        userRepository.save(user);
    }

    @Override
    public List<User> searchUsers(String criteria) {
        // Implement the logic to search for users by a specific criterion (e.g., name, email, etc.)
        return userRepository.searchUsers(criteria);
    }

    @Override
    public void addUserRole(User user, String role) {
        // Implement the logic to add a role to a user
        Set<String> roles = user.getRoles();
        roles.add(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public void removeUserRole(User user, String role) {
        // Implement the logic to remove a role from a user
        Set<String> roles = user.getRoles();
        roles.remove(role);
        user.setRoles(roles);
        userRepository.save(user);
    }

    @Override
    public boolean hasRole(User user, String role) {
        // Implement the logic to check if a user has a specific role
        Set<String> roles = user.getRoles();
        return roles.contains(role);
    }

    @Override
    public void lockUserAccount(User user) {
        // Implement the logic to lock a user's account
        user.setAccountLocked(true); // Assuming you have an "accountLocked" property
        userRepository.save(user);
    }

    @Override
    public void unlockUserAccount(User user) {
        // Implement the logic to unlock a user's account
        user.setAccountLocked(false); // Assuming you have an "accountLocked" property
        userRepository.save(user);
    }

    @Override
    public Set<String> getUserRoles(User user) {
        // Implement the logic to retrieve the user's role(s)
        return user.getRoles();
    }
}
