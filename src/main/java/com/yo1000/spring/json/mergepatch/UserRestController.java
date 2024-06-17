package com.yo1000.spring.json.mergepatch;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserRestController {
    private static User user = new User(
            1,
            "alice",
            "Liddell",
            "Alice",
            7
    );

    @GetMapping(path = "/{id}")
    public User get(@PathVariable("id") Integer id) {
        if (!id.equals(user.getId())) {
            return null;
        }

        return user;
    }

    @PatchMapping(path = "/{id}", consumes = "application/merge-patch+json")
    public User patch(@PathVariable("id") Integer id, @RequestBody UserPatchRequest patch) {
        if (!id.equals(user.getId())) {
            return null;
        }

        if (patch.getUsername() != null) {
            patch.getUsername().ifPresentOrElse(
                    user::setUsername,
                    () -> user.setUsername(null));
        }

        if (patch.getFamilyName() != null) {
            patch.getFamilyName().ifPresentOrElse(
                    user::setFamilyName,
                    () -> user.setFamilyName(null));
        }

        if (patch.getGivenName() != null) {
            patch.getGivenName().ifPresentOrElse(
                    user::setGivenName,
                    () -> user.setGivenName(null));
        }

        if (patch.getAge() != null) {
            patch.getAge().ifPresentOrElse(
                    user::setAge,
                    () -> user.setAge(null));
        }

        return user;
    }
}
