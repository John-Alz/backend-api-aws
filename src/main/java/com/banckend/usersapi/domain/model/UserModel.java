package com.banckend.usersapi.domain.model;

public class UserModel {

    private Long id;
    private String name;
    private String identityNumber;
    private String email;

    public UserModel(Long id, String name, String identityNumber, String email) {
        this.id = id;
        this.name = name;
        this.identityNumber = identityNumber;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
