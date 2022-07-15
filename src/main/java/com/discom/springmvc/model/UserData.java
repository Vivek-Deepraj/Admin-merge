package com.discom.springmvc.model;

public class UserData {
    private String username, firstname, lastname, email, profile;

    public UserData(String username, String firstname, String lastname,
                    String email, String profile) {
        super();
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.profile = profile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }


}
