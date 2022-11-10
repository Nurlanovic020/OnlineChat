package com.company.client.ui;

import com.company.client.util.ScannerUtil;
import com.company.server.controller.UserController;
import com.company.server.database.Database;
import com.company.server.model.Group;
import com.company.server.model.User;
import com.company.server.service.UserService;

import java.util.List;
import java.util.UUID;

public class UserUI {
    public static void adminPage() {
        int operation = adminMenu();
        System.out.println();


            switch (operation){
                case 1: UserUI.showAllUsers();break;
                case 2: UserUI.blockUser();break;
                case 3: UserUI.unBlockUser();break;
                case 4: UserUI.deleteUser();break;
                case 5: AuthUI.changePassword();break;
                case 0: AuthUI.logOut();

            }
        }
    public static void userPage() {
        int operation = userMenu();
        System.out.println();

        switch (operation){
            case 1: MassageUI.sendMessageToUser();break;
            case 2: MassageUI.sendMessageToGroup();break;
            case 3: GroupUI.createGroup();break;
            case 4: MassageUI.checkMessage();break;
            case 5: AuthUI.changePassword();break;
            case 0: AuthUI.logOut();break;
        }

    }



    private static void deleteUser() {
        showAllUsers();

        System.out.print("Enter user id :");
        UUID id = UUID.fromString(ScannerUtil.SCANNER_STR.nextLine());

        String result = UserController.deleteUser(id);

        System.out.println(result);

    }

    private static void unBlockUser() {
        showAllUsers();

        System.out.print("Enter user id :");
        UUID id = UUID.fromString(ScannerUtil.SCANNER_STR.nextLine());

        String result = UserController.unBlockUser(id);

        System.out.println(result);

    }

    private static void blockUser() {

        showAllUsers();

        System.out.print("Enter user id :");
        UUID id = UUID.fromString(ScannerUtil.SCANNER_STR.nextLine());

        String result = UserController.blockUser(id);

        System.out.println(result);



    }

    public static void showAllUsers() {
        List<User> userList = UserController.getUserList();
        if(userList.isEmpty()){
            System.err.println("NO USERS");
        }else {
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }


    private static int adminMenu(){
        System.out.println();
        System.out.println("1. Show all Users");
        System.out.println("2. Block User");
        System.out.println("3. Unblock User");
        System.out.println("4. Remove User");
        System.out.println("5. Change password");
        System.out.println("0. Logout");
        System.out.print("Enter operation number : ");

        return ScannerUtil.SCANNER_NUM.nextInt();
    }

    private static int userMenu(){
        System.out.println();
        System.out.println("1. Send message to a User");
        System.out.println("2. Send message to a Group");
        System.out.println("3. Create new Group");
        System.out.println("4. Check messages");
        System.out.println("5. Change password");
        System.out.println("0. Logout");
        System.out.print("Enter operation number : ");

        return ScannerUtil.SCANNER_NUM.nextInt();
    }


}
