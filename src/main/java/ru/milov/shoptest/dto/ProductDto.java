package ru.milov.shoptest.dto;

import lombok.Data;
import ru.milov.shoptest.entity.User;
import java.math.BigDecimal;

@Data
public class ProductDto {

    private User user;

    private String name;

    private String vendorCode;

    private BigDecimal value;
}
