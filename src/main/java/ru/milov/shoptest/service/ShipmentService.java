package ru.milov.shoptest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.milov.shoptest.dto.ShipmentDto;
import ru.milov.shoptest.mappers.ShipmentMapper;
import ru.milov.shoptest.repository.ShipmentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;

    public List<ShipmentDto> findAll() {
        return shipmentRepository.findAll().stream()
                .map(ShipmentMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }
}
