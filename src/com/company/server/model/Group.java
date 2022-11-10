package com.company.server.model;

import com.company.server.database.Database;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Group {
    private UUID id;
    private User owner;
    private String groupName;
    private List<User> users;

    public Group(User owner, String groupName, List<User> users) {
        this.id = UUID.randomUUID();
        this.owner = owner;
        this.groupName = groupName;
        this.users = users;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UUID getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
       List<String> names = new ArrayList<>();

        for (User user : users) {
            names.add(user.getFullName());
        }

        return "[" +
                "id=" + id +
                ", owner=" + owner.getFullName() +
                ", groupName='" + groupName + '\'' +
                ", users=" + names +
                ']';
    }


    /*public static List<String> getUserName(UUID id){

        List<String> userList = new ArrayList<>();

        for (Group group : Database.groupList) {
            if(group.getId().equals(id)){

                for (User user : group.getUsers()) {
                    userList.add(user.getFullName());
                }
        }

    }

        return userList;



    }*/
}
