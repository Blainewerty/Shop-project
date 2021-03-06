package ru.milov.shoptest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.milov.shoptest.dto.ShipmentDto;
import ru.milov.shoptest.entity.Product;
import ru.milov.shoptest.entity.Shipment;
import ru.milov.shoptest.mappers.ShipmentMapper;
import ru.milov.shoptest.repository.ShipmentRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentMapper shipmentMapper;

    private final ShipmentRepository shipmentRepository;

    @Transactional(readOnly = true)
    public List<ShipmentDto> findAll() {
        return shipmentRepository.findAll().stream()
                .map(shipmentMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateShipment(Shipment shipment){
        shipmentRepository.save(shipment);
    }

    public ShipmentDto addShipment(Product product, Shipment shipment) {
        shipment.setProduct(product);
        return shipmentMapper.toDto(shipmentRepository.save(shipment));
    }
}
