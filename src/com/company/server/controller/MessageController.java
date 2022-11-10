package com.company.server.controller;

import com.company.server.model.Message;
import com.company.server.service.MessageServer;

import java.util.List;
import java.util.UUID;

public class MessageController {
    public static String sendMassage(UUID id, String message) {
        return MessageServer.sendMessage(id,message);
    }

    public static List<Message> checkMessage() {

        return MessageServer.checkMessage();
    }

    public static String sendMassageToGroup(UUID fromUserId, UUID toGroupId, String message) {
        return MessageServer.sendMessageToGroup(fromUserId,toGroupId,message);
    }
}
