package com.Anudip.TrainTicketReservationSystem.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "phone_no") // New column for phone number
    private String phoneNo;

    @Column(name = "address")
    private String address;

    @Column(name = "password")
    private String password;

    @Column(name = "rule")
    private String rule;

    @Column(name = "reg_date")
    private Date regDate;

    @Column(name = "last_activity")
    private Date lastActivity;

    @Column(name = "account_locked")
    private boolean accountLocked;

    @ElementCollection
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    private Set<String> roles;

    // Constructors, getters, setters, and other methods...

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Default constructor
    public User() {
    }

    // Parameterized constructor
    public User(Long userId, String name, String email, String phoneNo, String address, String password, String rule,
            Date regDate, Date lastActivity, boolean accountLocked, Set<String> roles) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.address = address;
        this.password = password;
        this.rule = rule;
        this.regDate = regDate;
        this.lastActivity = lastActivity;
        this.accountLocked = accountLocked;
        this.roles = roles;
    }

    // Getter and setter methods

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setAccountLocked(boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    public boolean isAccountLocked() {
        return accountLocked;
    }

    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", phoneNo=" + phoneNo
            + ", address=" + address + ", password=" + password + ", rule=" + rule + ", regDate=" + regDate
            + ", lastActivity=" + lastActivity + "]";
    }
}
