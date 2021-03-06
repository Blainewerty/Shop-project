package ru.milov.shoptest.entity;

import javax.persistence.Table;

@Table(name = "role")
public enum Roles
{
    ADMIN,USER
}
