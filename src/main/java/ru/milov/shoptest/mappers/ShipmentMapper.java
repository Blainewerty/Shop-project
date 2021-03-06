package ru.milov.shoptest.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import ru.milov.shoptest.dto.ShipmentDto;
import ru.milov.shoptest.entity.Shipment;

@Mapper
public interface ShipmentMapper {

    ShipmentMapper INSTANCE = Mappers.getMapper(ShipmentMapper.class);

    ShipmentDto toDto(Shipment shipment);
}
