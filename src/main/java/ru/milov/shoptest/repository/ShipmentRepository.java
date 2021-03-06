package ru.milov.shoptest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.milov.shoptest.entity.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}
