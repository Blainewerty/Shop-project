package ru.milov.shoptest.dto;

import lombok.Data;
import ru.milov.shoptest.entity.Measure;
import ru.milov.shoptest.entity.Product;
import java.math.BigDecimal;
import java.util.Set;

@Data
public class ShipmentDto {

    private Product product;

    private String barcode;

    private BigDecimal weight;

    private Set<Measure> measures;
}
