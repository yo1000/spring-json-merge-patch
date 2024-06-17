package com.yo1000.spring.json.mergepatch;

import java.util.Optional;

public class UserPatchRequest {
    private Optional<Integer> id;
    private Optional<String> username;
    private Optional<String> familyName;
    private Optional<String> givenName;
    private Optional<Integer> age;

    public UserPatchRequest() {}

    public UserPatchRequest(Optional<Integer> id, Optional<String> username, Optional<String> familyName, Optional<String> givenName, Optional<Integer> age) {
        this.id = id;
        this.username = username;
        this.familyName = familyName;
        this.givenName = givenName;
        this.age = age;
    }

    public Optional<Integer> getId() {
        return id;
    }

    public void setId(Optional<Integer> id) {
        this.id = id;
    }

    public Optional<String> getUsername() {
        return username;
    }

    public void setUsername(Optional<String> username) {
        this.username = username;
    }

    public Optional<String> getFamilyName() {
        return familyName;
    }

    public void setFamilyName(Optional<String> familyName) {
        this.familyName = familyName;
    }

    public Optional<String> getGivenName() {
        return givenName;
    }

    public void setGivenName(Optional<String> givenName) {
        this.givenName = givenName;
    }

    public Optional<Integer> getAge() {
        return age;
    }

    public void setAge(Optional<Integer> age) {
        this.age = age;
    }
}
