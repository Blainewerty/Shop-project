package ru.milov.shoptest.entity;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Table;

@Table(name = "roles")
public enum Role implements GrantedAuthority
{
    ADMIN,USER;

    @Override
    public String getAuthority()
    {
        return name();
    }
}
