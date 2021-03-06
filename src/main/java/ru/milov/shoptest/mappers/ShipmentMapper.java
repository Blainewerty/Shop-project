package ru.milov.shoptest.mappers;

import org.mapstruct.Mapper;
import ru.milov.shoptest.dto.ShipmentDto;
import ru.milov.shoptest.entity.Shipment;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

    ShipmentDto toDto(Shipment shipment);
}
