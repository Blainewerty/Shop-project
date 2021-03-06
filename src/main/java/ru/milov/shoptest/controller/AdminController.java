package ru.milov.shoptest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.milov.shoptest.dto.ProductDto;
import ru.milov.shoptest.dto.ShipmentDto;
import ru.milov.shoptest.dto.UserDto;
import ru.milov.shoptest.entity.Shipment;
import ru.milov.shoptest.service.ProductService;
import ru.milov.shoptest.service.ShipmentService;
import ru.milov.shoptest.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
@PreAuthorize(value = "hasAuthority('ADMIN')")
public class AdminController {

    private final UserService userService;

    private final ProductService productService;

    private final ShipmentService shipmentService;

    @GetMapping("/users")
    public List<UserDto> findAllUsers (){
        return userService.findAll();
    }

    @GetMapping("/products")
    public List<ProductDto> findAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/shipments")
    public List<ShipmentDto> findAllShipments(){
        return shipmentService.findAll();
    }
}
