package com.company.client.ui;

import com.company.Main;
import com.company.client.util.ScannerUtil;
import com.company.server.controller.GroupController;
import com.company.server.controller.UserController;
import com.company.server.database.Database;
import com.company.server.model.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupUI {
    public static void createGroup() {
        System.out.println("Enter a group name: ");
        String groupName = ScannerUtil.SCANNER_STR.nextLine();
        int operation = 0;
        List<String> phoneNumber = new ArrayList<>();
        do {
            System.out.println("Do you want add member to group(1.yes, 2.no): ");
            operation = ScannerUtil.SCANNER_NUM.nextInt();
            if(operation == 1){
                System.out.println("Enter a members phone number: ");
                phoneNumber.add(ScannerUtil.SCANNER_STR.nextLine());
            }
        }while(operation != 2);
        String res = GroupController.createGroup(Main.sessionUser,groupName,phoneNumber);
        if(res != null){
            System.out.println(res);
        }else{
            System.out.println("Group was successfully created!!");
        }
    }

        /*int operation = menu();

        switch (operation){
            case 1: GroupUI.addUserToGroup();break;

        }*/




   /* private static void addUserToGroup() {
        UserUI.showAllUsers();

        System.out.print("Enter user id :");
        UUID id = UUID.fromString(ScannerUtil.SCANNER_STR.nextLine());


        String result = GroupController.addUserToGroup(id);

        System.out.println(result);


    }
*/

    public static int menu(){
        System.out.println("Do you want add user to group");
        System.out.println("1. yes");
        System.out.println("2. no");
        System.out.print("Enter operation number : ");

        return ScannerUtil.SCANNER_NUM.nextInt();
    }

    public static void showAllGroups() {

        List<Group> groupList = GroupController.getGroupList();

        if(groupList == null || groupList.isEmpty()){
            System.err.println("You don't have any groups");
        }

        groupList.forEach(System.out::println);
        
    }
}
