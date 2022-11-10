package com.company.server.model;

import java.util.UUID;

public class Message {
    private UUID id;
    private User fromUser;
    private User toUser;
    private Group toGroup;
    private String messageText;

    public Message(User fromUser, User toUser, String messageText) {
        this.id = UUID.randomUUID();
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.messageText = messageText;
    }

    public Message(User fromUser, Group toGroup, String messageText) {
        this.fromUser = fromUser;
        this.toGroup = toGroup;
        this.messageText = messageText;
    }

    public void setFromUser(User fromUser) {
        this.fromUser = fromUser;
    }

    public void setToUser(User toUser) {
        this.toUser = toUser;
    }

    public void setToGroup(Group toGroup) {
        this.toGroup = toGroup;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public UUID getId() {
        return id;
    }

    public User getFromUser() {
        return fromUser;
    }

    public User getToUser() {
        return toUser;
    }

    public Group getToGroup() {
        return toGroup;
    }

    public String getMessageText() {
        return messageText;
    }

    @Override
    public String toString() {
        if(toUser == null){
        return "[" +
                "id=" + this.id +
                ", fromUser=" + fromUser.getFullName() +
                ", toGroup=" + toGroup.getGroupName() +
                ", messageText='" + messageText + '\'' +
                ']';
        }
            return "[" +
                    "id=" + id +
                    ", fromUser=" + fromUser.getFullName() +
                    ", toUser=" + toUser.getFullName() +
                    ", messageText='" + messageText + '\'' +
                    ']';
    }
}
