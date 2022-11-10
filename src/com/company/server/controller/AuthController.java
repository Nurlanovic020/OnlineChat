package com.company.server.controller;

import com.company.server.service.AuthService;

public class AuthController {


    public static String register(String fullName, String phoneNumber, String password) {
        return AuthService.register(fullName,phoneNumber,password);
    }

    public static String login(String phoneNumber, String password) {
        return AuthService.login(phoneNumber,password);
    }

    public static void logOut() {
        AuthService.logout();
    }

    public static String changePassword(String currentPassword, String newPassword, String newPasswordAgain) {
        return AuthService.changePassword(currentPassword,newPassword,newPasswordAgain);
    }
}
