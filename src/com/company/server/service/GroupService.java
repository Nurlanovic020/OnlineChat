package com.company.server.service;

import com.company.Main;
import com.company.server.database.Database;
import com.company.server.model.Group;
import com.company.server.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GroupService {
    List<User> userListInGroup = new ArrayList<>();
    public static String addUserToGroup(UUID id) {
        return null;
    }

    public static String createGroup(User owner, String groupName, List<String> phoneNumber){
        if(groupName.isBlank()) return "Group should have a name";
        Group newGroup = new Group(owner, groupName, getUsersByPhoneNumber(phoneNumber));
        System.out.println(newGroup);
        Database.groupList.add(newGroup);
        return null;
    }

    private static List<User> getUsersByPhoneNumber(List<String> phoneNumber){
        List<User> users = new ArrayList<>();
        if(phoneNumber == null) return null;
        for (User user : Database.userList) {
            for (String s : phoneNumber) {
                if(user.getPhoneNumber().equals(s)){
                    users.add(user);
                }
            }
        }
        return users;
    }


    public static User getUserById(UUID id){

    for (User user : Database.userList) {
        if(user.getId().equals(id)){
            return user;
        }
    }
    return null;
    }

    public static List<Group> getGroupList() {
        return Database.groupList;
    }
}
