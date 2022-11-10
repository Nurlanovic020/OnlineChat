package com.company;

import com.company.client.ui.MainUI;
import com.company.server.database.Database;
import com.company.server.model.User;

public class Main {

    public static User sessionUser = null;


    public static void main(String[] args) {

        System.out.println("\t\t\t  *** *** WELCOME TO ONLINE CHAT PROGRAM *** ***");

        Database.loadDate();

        MainUI.run();

    }

}
