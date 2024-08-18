package com.yo1000.spring.json.mergepatch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
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

    private final ObjectMapper objectMapper;

    public UserRestController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @GetMapping(path = "/{id}")
    public User get(@PathVariable("id") Integer id) {
        if (!id.equals(user.getId())) {
            return null;
        }

        return user;
    }

    // Refer from https://stackoverflow.com/a/65649814/5610904
    @PatchMapping(path = "/{id}", consumes = "application/merge-patch+json")
    public User patch(@PathVariable("id") Integer id, @RequestBody String json) throws JsonProcessingException {
        ObjectReader reader = new ValidatableObjectReader(objectMapper.readerForUpdating(user));

        user = reader.readValue(json);

        return user;
    }
}
