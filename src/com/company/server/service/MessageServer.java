package com.company.server.service;

import com.company.Main;
import com.company.server.database.Database;
import com.company.server.model.Group;
import com.company.server.model.Message;
import com.company.server.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MessageServer {
    public static String sendMessage(UUID id, String message){

        if(Main.sessionUser.getId().equals(id)){
            System.err.println("you can't send message to yourself ");
        }

        if(Main.sessionUser.isBlocked()){
            System.err.println("You are blocked !!");
            return "";
        }

        User user = getUserById(id);
        if(user == null){
            if(user.isAdmin()){
                System.err.println("you can't sent message to Admin");
                return "";
            }

            if(user.isBlocked()){
                System.err.println("you can't sent message to blocked user");
                return "";
            }

            System.err.println("user not found !!");
            return "";
        }

        if(message == null || message.isBlank()){
            System.err.println("message can't be empty !");
            return "";
        }

        Message sentMessage = new Message(Main.sessionUser,user,message);



        Database.messageListToUser.add(sentMessage);



            return "message successfully sent ";

    }


    public static User getUserById(UUID id){
        for (User user : Database.userList) {
           if(user.getId().equals(id)){
            return user;
           }
        }
        return null;
    }

    public static List<Message> checkMessage() {

        List<Message> messageList = new ArrayList<>();

        List<Group> userInGroup = getUserInGroup(Main.sessionUser.getId());

        for (Group group : userInGroup) {
            for (Message message : Database.messageListToGroup) {
                if (message.getToGroup().getId().equals(group.getId())) {
                        messageList.add(message);
                    }
            }
        }


        for (Message message : Database.messageListToUser) {
            if(Main.sessionUser.getId().equals(message.getToUser().getId())){
                messageList.add(message);
            }
        }



        return messageList;

    }

    public static List<Group> getUserInGroup(UUID id){

        List<Group> reversedGroupMessagesToUser = new ArrayList<>();

        for (Group group : Database.groupList) {
            for (User user : group.getUsers()) {
                if(user.getId().equals(id)){
                    reversedGroupMessagesToUser.add(group);
                }
            }
        }
        return reversedGroupMessagesToUser;
    }


    public static String sendMessageToGroup(UUID fromUserID, UUID toGroupID, String message) {
        if(toGroupID == null ){
            System.err.println("wrong group id ");
            return "";
        }

        if(message == null || message.isBlank()){
            System.err.println("message can't be empty !");
            return "";
        }

        Group toGroup = getGroupByID(toGroupID);
        User fromUser = Main.sessionUser;

        if(toGroup == null){
            System.err.println("group not found");
            return "";
        }


        Message sendMessageToGroup = new Message(fromUser,toGroup,message);

        Database.messageListToGroup.add(sendMessageToGroup);
        // Database.messageList.add();

        return "message successfully sent ";
    }


    public static Group getGroupByID(UUID id){
        for (Group group : Database.groupList) {
            if(group.getId().equals(id)){
                return group;
            }
        }
        return null;
    }
}


