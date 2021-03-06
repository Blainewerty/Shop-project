package ru.milov.shoptest.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.milov.shoptest.entity.Product;

import java.util.List;

@Data
@Accessors(chain = true)
public class UserDto {

    private String login;

    private String email;

    private List<Product> products;
}
