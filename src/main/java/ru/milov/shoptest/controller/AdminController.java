package ru.milov.shoptest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.milov.shoptest.dto.UserDto;
import ru.milov.shoptest.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@PreAuthorize(value = "hasAuthority('ADMIN')")
public class AdminController {

    private final UserService userService;

    @GetMapping("/")
    public List<UserDto> findAllUsers (){
        return userService.findAll();
    }
}
