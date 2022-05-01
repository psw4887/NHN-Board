package com.nhnacademy.data;

public class User implements Users{
    private String name;
    private String id;
    private String pwd;
    private String proFile;

    public User(String name, String id, String pw, String proFile) {
        this.name = name;
        this.id = id;
        this.pwd = pw;
        this.proFile = proFile;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getPassword() {
        return this.pwd;
    }

    @Override
    public void setPassword(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getProfileFileName() {
        return this.proFile;
    }

    @Override
    public void setProfileFileName(String profileFileName) {
        this.proFile = profileFileName;
    }
}
