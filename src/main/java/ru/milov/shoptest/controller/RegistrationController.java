package ru.milov.shoptest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.milov.shoptest.entity.User;
import ru.milov.shoptest.service.UserService;

@Controller
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/registration")
    public String registerUser(@RequestBody User user) {
        System.out.println(user);
        if (!userService.addUser(user)) {
            return "User exist!";
        } else userService.addUser(user);
        return "Success!";
    }

    @GetMapping("/activate/{code}")
    public String activate(@PathVariable String code) {

        boolean isActivated = userService.activateUser(code);

        if (isActivated) {
            return "All good!";
        } else {
            return "Not good!";
        }
    }
}