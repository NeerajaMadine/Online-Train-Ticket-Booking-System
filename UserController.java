package com.Anudip.TrainTicketReservationSystem.contoller;

import com.Anudip.TrainTicketReservationSystem.entity.User;
import com.Anudip.TrainTicketReservationSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{userId}/changePassword")
    public void changePassword(@PathVariable Long userId, @RequestParam String newPassword) {
        User user = userService.getUserById(userId);
        userService.changePassword(user, newPassword);
    }

    @PutMapping("/{userId}/lock")
    public void lockUserAccount(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        userService.lockUserAccount(user);
    }

    @PutMapping("/{userId}/unlock")
    public void unlockUserAccount(@PathVariable Long userId) {
        User user = userService.getUserById(userId);
        userService.unlockUserAccount(user);
    }
    @PutMapping("/{userId}/addRole")
    public void addUserRole(@PathVariable Long userId, @RequestParam String roleName) {
        User user = userService.getUserById(userId);
        userService.addUserRole(user, roleName);
    }

    @PutMapping("/{userId}/removeRole")
    public void removeUserRole(@PathVariable Long userId, @RequestParam String roleName) {
        User user = userService.getUserById(userId);
        userService.removeUserRole(user, roleName);
    }
    @GetMapping("/{userId}/hasRole")
    public boolean hasRole(@PathVariable Long userId, @RequestParam String roleName) {
        User user = userService.getUserById(userId);
        return userService.hasRole(user, roleName);
    }
}
