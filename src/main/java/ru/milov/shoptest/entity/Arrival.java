package ru.milov.shoptest.entity;

import lombok.Data;
import java.util.List;

@Data
public class Arrival {

    Product product;
    Shipment shipments;
}
