package ru.milov.shoptest.dto;

import lombok.Data;
import ru.milov.shoptest.entity.Product;
import ru.milov.shoptest.entity.Shipment;

@Data
public class Arrival {

    private final Product product;

    private final Shipment shipments;
}
