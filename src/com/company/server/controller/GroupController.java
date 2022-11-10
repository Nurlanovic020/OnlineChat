package com.company.server.controller;

import com.company.server.model.Group;
import com.company.server.model.User;
import com.company.server.service.GroupService;

import java.util.List;
import java.util.UUID;

public class GroupController {
    public static String addUserToGroup(UUID id) {
       return GroupService.addUserToGroup(id);
    }



    public static String createGroup(User owner, String groupName, List<String> phoneNumber) {
        return GroupService.createGroup(owner,groupName,phoneNumber);
    }

    public static List<Group> getGroupList() {
        return GroupService.getGroupList();
    }
}
