package ru.milov.shoptest.util;

import org.springframework.security.core.context.SecurityContextHolder;
import ru.milov.shoptest.entity.User;

public class UserFromContext {

    public User getUser(){
        return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
