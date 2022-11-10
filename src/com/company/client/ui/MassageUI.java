package com.company.client.ui;

import com.company.Main;
import com.company.client.util.ScannerUtil;
import com.company.server.controller.MessageController;
import com.company.server.database.Database;
import com.company.server.model.Message;
import com.company.server.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MassageUI {
    public static void sendMessageToUser() {
        UserUI.showAllUsers();

        System.out.print("Enter user id :");
        UUID id = UUID.fromString(ScannerUtil.SCANNER_STR.nextLine());

        System.out.print("Enter message : ");
        String message = ScannerUtil.SCANNER_STR.nextLine();

        String result = MessageController.sendMassage(id,message);

        System.out.println(result);


    }

    public static void sendMessageToGroup() {
        GroupUI.showAllGroups();

        System.out.print("Enter group id :");
        UUID id = UUID.fromString(ScannerUtil.SCANNER_STR.nextLine());

        System.out.print("Enter message : ");
        String message = ScannerUtil.SCANNER_STR.nextLine();

        String result = MessageController.sendMassageToGroup(Main.sessionUser.getId(), id,message);

        System.out.println(result);




    }

    public static void checkMessage() {

        List<Message> res = MessageController.checkMessage();

        if(res == null) {
            System.err.println("No messages");
        }else{
            for (Message message: Database.messageListToUser){
                System.out.println(message);
            }
            for (Message message: Database.messageListToGroup){
                System.out.println(message);
            }

        }

    }
}
