package com.company.server.service;

import com.company.server.database.Database;
import com.company.server.model.User;

import java.util.List;
import java.util.UUID;

public class UserService {
    public static User getUserByPhoneNumber(String phoneNumber) {
        for (User user : Database.userList) {
            if(user.getPhoneNumber().equals(phoneNumber)){
                return user;
            }
        }
        return null;
    }

    public static List<User> getUsers() {
        return Database.userList;
    }

    public static String blockUser(UUID id) {
        for (User user : Database.userList) {
            if(user.isBlocked()){
                return "this user already blocked";
            }
            if(user.getId().equals(id)){
                user.setBlocked(true);
                return "User blocked";
            }
        }
        System.err.println("This user not found !");
        return "";
    }

    public static String unBlockUser(UUID id) {
        if(id == null){
            System.err.println("User not found");
            return "";

        }
        for (User user : Database.userList) {
            if(user.getId().equals(id)){
                if(!user.isBlocked()){
                    return "this user already unblocked";
                }
                user.setBlocked(false);
                return "User unblocked";

            }
        }
        return "User not found";
    }

    public static String deleteUser(UUID id) {
        if(id == null){
            System.err.println("Wrong id");
            return "";
        }

        Database.userList.removeIf(user -> user.getId().equals(id));

        return "user deleted";
    }
}
