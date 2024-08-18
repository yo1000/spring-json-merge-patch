package com.yo1000.spring.json.mergepatch;

import jakarta.validation.constraints.Pattern;

public class User {
    private Integer id;
    @Pattern(regexp = "^[0-9A-Za-z]+$")
    private String username;
    private String familyName;
    private String givenName;
    private Integer age;

    public User() {}

    public User(Integer id, String username, String familyName, String givenName, Integer age) {
        this.id = id;
        this.username = username;
        this.familyName = familyName;
        this.givenName = givenName;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
