package com.example.lightupchat;

public class UserModel {
    private String usersId, userName, useremail, userPassword;

    public UserModel(){

    }

    public UserModel(String usersId, String userName, String useremail, String userPassword) {
        this.usersId = usersId;
        this.userName = userName;
        this.useremail = useremail;
        this.userPassword = userPassword;
    }

    public String getUsersId() {
        return usersId;
    }

    public void setUsersId(String usersId) {
        this.usersId = usersId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
