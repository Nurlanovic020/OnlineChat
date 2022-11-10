package com.company.client.ui;

import com.company.client.util.ScannerUtil;
import com.company.server.controller.AuthController;

public class AuthUI {
    public static void login() {
        System.out.print("Enter phone number (+998XXYYYYYYY) : ");
        String phoneNumber = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Enter password : ");
        String password = ScannerUtil.SCANNER_STR.nextLine();

        String response = AuthController.login(phoneNumber,password);
        System.out.println(response);



    }

    public static void register() {
        System.out.println();

        System.out.print("Enter full name : ");
        String fullName = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Enter phone number (+998XXYYYYYYY) : ");
        String phoneNumber = ScannerUtil.SCANNER_STR.nextLine();

        System.out.print("Enter password : ");
        String password = ScannerUtil.SCANNER_STR.nextLine();

        String response = AuthController.register(fullName,phoneNumber,password);
        System.out.println(response);



    }


    public static void logOut() {
        AuthController.logOut();
    }
    public static void changePassword() {
        System.out.print("Enter current password : ");
        String currentPassword = ScannerUtil.SCANNER_STR.nextLine();
        System.out.print("Enter new password : ");
        String newPassword = ScannerUtil.SCANNER_STR.nextLine();
        System.out.print("Enter new password again : ");
        String newPasswordAgain = ScannerUtil.SCANNER_STR.nextLine();

        String response = AuthController.changePassword(currentPassword,newPassword,newPasswordAgain);
        System.out.println(response);

    }
}
