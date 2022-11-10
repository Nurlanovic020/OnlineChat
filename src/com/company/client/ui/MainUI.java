package com.company.client.ui;

import com.company.Main;
import com.company.client.util.ScannerUtil;

public class MainUI {

    public static void run(){

        while (true){
    if(Main.sessionUser == null){

        System.out.println();
        int operation = baseMenu();

        if(operation == 0)break;

        switch (operation) {
            case 1 -> AuthUI.login();
            case 2 -> AuthUI.register();
        }
        }else{
        if(Main.sessionUser.isAdmin()){
            UserUI.adminPage();
        }else{
            UserUI.userPage();
        }
    }


    }

    }

    public static int baseMenu(){
        System.out.println();

        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("0. Exit");
        System.out.print("Enter operation number : ");
        return ScannerUtil.SCANNER_NUM.nextInt();
    }

}

