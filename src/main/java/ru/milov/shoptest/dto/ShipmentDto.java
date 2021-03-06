package ru.milov.shoptest.dto;

import lombok.Data;
import ru.milov.shoptest.entity.Measure;
import ru.milov.shoptest.entity.Product;
import ru.milov.shoptest.entity.Shipment;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Data
public class ShipmentDto {

    private Product product;

    private String barcode;

    private BigDecimal weight;

    private Set<Measure> measures;

    private List<Shipment> Shipments;
}
