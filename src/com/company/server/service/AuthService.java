package com.company.server.service;

import com.company.Main;
import com.company.server.database.Database;
import com.company.server.model.User;

public class AuthService {


    public static String register(String fullName, String phoneNumber, String password) {

        String check = checkParameters(fullName,phoneNumber,password);
        if (!check.equals("true")) {
            return check;
        }


        User user = UserService.getUserByPhoneNumber(phoneNumber);

        if(user != null ){
            System.err.println("this number already taken");
            return "";
        }

        user = new User(fullName,phoneNumber,password,false,false);

        Database.userList.add(user);


        return String.format("%s successfully registered! ",user.getFullName());

    }
    public static String login(String phoneNumber, String password) {

        String check = checkParameters("fullName",phoneNumber,password);
        if(!check.equals("true")){
            return check;
        }

        User user = UserService.getUserByPhoneNumber(phoneNumber);


        if (user == null || !user.getPassword().equals(password)) {
            System.err.print("Something went wrong");
            return "";
        }

        Main.sessionUser = user;


        return String.format("%s welcome your cabinet",user.getFullName());
    }

    private static String checkParameters(String fullName, String phoneNumber, String password) {
        if(fullName == null || fullName.isBlank()){
            System.err.print("Full name is required");
            return "";
        }

        if(phoneNumber == null || phoneNumber.isBlank()){
            System.err.print("Phone number is required");
            return "";
        }

        if(!phoneNumber.matches("([+]998)?\\d{9}")){
            System.err.print("Invalid phone number");
            return "";
        }

        if (password.trim().length() < 8) {
            System.err.print("Password must be at least 8 characters");
            return " ";
        }

        if(!password.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")){
            System.err.print("password must contain at least 1 uppercase letter, 1 lowercase letter, 1 number !!!");
            return "";
        }


        return "true";
    }


    public static void logout() {
        Main.sessionUser = null;
    }

    public static String changePassword(String currentPassword, String newPassword, String newPasswordAgain) {
        if(!Main.sessionUser.getPassword().equals(currentPassword)){
            System.err.print("Wrong password");
            return "";
        }

        if(newPassword == null || newPassword.isBlank()){
            System.err.println("New password required");
            return "";
        }

        if (newPassword.trim().length() < 8) {
            System.err.println("Password must be at least 8 characters");
            return " ";
        }


        if(!newPassword.equals(newPasswordAgain)){
            System.err.println("Password must be matches");
            return "";
        }

        Main.sessionUser.setPassword(newPassword);

        return "Your password successfully changed";
    }
}
