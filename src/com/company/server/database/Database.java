package com.company.server.database;

import com.company.server.model.Group;
import com.company.server.model.Message;
import com.company.server.model.User;

import java.util.ArrayList;
import java.util.List;

public class Database {


    public static List<User>  userList = new ArrayList<>();
    public static List<Message>  messageListToUser = new ArrayList<>();
    public static List<Message>  messageListToGroup = new ArrayList<>();

    public static List<Group> groupList = new ArrayList<>();


    public static void loadDate() {
        User admin = new User("sa1dovch", "+998998875666",
                "Azam5666", true,false);
        userList.add(admin);

        userList.add(new User( "Isroil", "+998911111111",
                "Isroil111",false,false));

    userList.add(new User( "Eshmat", "+998901234567",
                "Eshmat123",false,false));

    userList.add(new User( "Toshmat", "+998901112233",
                "Toshmat123",false,false));




    }

}
