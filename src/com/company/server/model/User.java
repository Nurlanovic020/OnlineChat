package com.company.server.model;

import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String fullName;
    private String phoneNumber;
    private String password;
    private boolean admin;
    private boolean blocked;
    private List<Message> messageLists;


    public User( String fullName, String phoneNumber, String password, boolean admin, boolean blocked) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.admin = admin;
        this.blocked = blocked;
    }

    public User(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    public List<Message> getMessageLists() {
        return messageLists;
    }

    public void setMessageLists(List<Message> messageLists) {
        this.messageLists = messageLists;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", blocked=" + blocked +
                ']';
    }
}
