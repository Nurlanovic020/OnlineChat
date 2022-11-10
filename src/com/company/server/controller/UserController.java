package com.company.server.controller;

import com.company.server.model.User;
import com.company.server.service.UserService;

import java.util.List;
import java.util.UUID;

public class UserController {


    public static List<User> getUserList() {
        return UserService.getUsers();
    }

    public static String blockUser(UUID id) {
        return UserService.blockUser(id);
    }

    public static String unBlockUser(UUID id) {
        return UserService.unBlockUser(id);
    }

    public static String deleteUser(UUID id) {
        return UserService.deleteUser(id);
    }
}
