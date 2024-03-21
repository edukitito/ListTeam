package com.springwithmongo.listteam.entities;

public class UserLogin {
    private String email;
    private String tokem;

    public UserLogin(String email, String tokem) {
        this.email = email;
        this.tokem = tokem;
    }

    public UserLogin(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTokem() {
        return tokem;
    }

    public void setTokem(String tokem) {
        this.tokem = tokem;
    }
}
