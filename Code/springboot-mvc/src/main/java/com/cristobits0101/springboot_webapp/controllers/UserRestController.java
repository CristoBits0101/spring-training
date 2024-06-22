package com.cristobits0101.springboot_webapp.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cristobits0101.springboot_webapp.models.User;
import com.cristobits0101.springboot_webapp.models.dto.UserDto;
import org.springframework.web.bind.annotation.RequestParam;

// import org.springframework.web.bind.annotation.RequestBody;
// import java.util.HashMap;
// import java.util.Map;

/**
 * Option A
 */
@RestController
@RequestMapping("/api")
public class UserRestController {
    @GetMapping("/details")
    public UserDto details() {
        UserDto userDto = new UserDto();
        User user = new User("Cristo", "Suárez");
        userDto.setUser(user);
        userDto.setTitle(null);
        return userDto;
    }

    @GetMapping("/list")
    public List<User> list() {

        User user = new User();
        User user2 = new User();
        User user3 = new User();

        // ArrayList es rápido de leer.
        // List<User> users = new ArrayList<>();

        // LinkedList es rápido de escribir.
        // List<User> users = new LinkedList<>();

        // users.add(user);
        // users.add(user2);
        // users.add(user3);

        // Clase helpers.
        List<User> users = Arrays.asList();

        return users;
    }
}

/**
 * Option B
 */
// @RestController
// @RequestMapping("/api")
// public class UserRestController {

// /**
// * @param model
// * @return details template
// */
// @GetMapping("/details")
// public Map<String, Object> details() {
// User user = new User("Cristo", "Suárez");
// Map<String, Object> body = new HashMap<>();
// body.put("user", user);
// return body;
// // return user;
// }
// }

/**
 * Option C
 */
// @RestController
// @RequestMapping("/api")
// public class UserRestController {

// /**
// * @param model
// * @return details template
// */
// @GetMapping("/details")
// public Map<String, Object> details() {
// Map<String, Object> body = new HashMap<>();
// body.put("name", "Cristo");
// body.put("lastname", "Suárez");
// return body;
// }
// }

/**
 * Option D
 */
// @Controller
// @RequestMapping("/api")
// public class UserRestController {
// @ResponseBody
// @GetMapping("/details")
// public Map<String, Object> details() {
// Map<String, Object> body = new HashMap<>();
// body.put("name", "Cristo");
// body.put("lastname", "Suárez");
// return body;
// }
// }
