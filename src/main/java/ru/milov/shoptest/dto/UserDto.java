package ru.milov.shoptest.dto;

import lombok.Data;
import ru.milov.shoptest.entity.Product;
import java.util.List;

@Data
public class UserDto {

    private String login;

    private String email;

    private List<Product> products;
}
