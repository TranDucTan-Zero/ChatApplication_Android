package com.zero.chatapplication.Helper;

public class UsersClass {

     String name;
    String username;
    String imageUri;
String status;

    public UsersClass( String name, String username, String imageUri, String status) {

        this.name = name;
        this.username = username;
        this.imageUri = imageUri;
        this.status = status;
    }

    public UsersClass() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
