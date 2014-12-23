package com.zuno.linkdemo;


public class Comment {
    private String userName;
    private String comment;

    public Comment(String userName, String comment) {
        this.comment = comment;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
