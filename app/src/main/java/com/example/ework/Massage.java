package com.example.ework;

import java.util.Date;

public class Massage {
    public String userName;
    public String textMassage;
    private long messageTime;
    public Massage() {}
    public Massage(String userName,String textMassage) {
        this.userName=userName;
        this.textMassage=textMassage;

        this.messageTime= new Date().getTime();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTextMassage() {
        return textMassage;
    }

    public void setTextMassage(String textMassage) {
        this.textMassage = textMassage;
    }

    public long getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(long messageTime) {
        this.messageTime = messageTime;
    }
}
