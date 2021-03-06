package ru.milov.shoptest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.milov.shoptest.dto.ProductDto;
import ru.milov.shoptest.dto.ShipmentDto;
import ru.milov.shoptest.dto.UserDto;
import ru.milov.shoptest.entity.Arrival;
import ru.milov.shoptest.entity.Product;
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

    @PostMapping("/addProduct")
    public void addProduct(@RequestBody Arrival arrival){
        shipmentService.addShipment(arrival.getProduct(), arrival.getShipments());
        productService.addProduct(arrival.getProduct(), arrival.getShipments());
    }

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@RequestBody Product product){
        productService.deleteProduct(product);
    }

    @PutMapping("/updateProduct/{vendorCode}")
    public void updateProduct(@RequestBody Product product,
                              @PathVariable String vendorCode){
        productService.updateProduct(product, vendorCode);
    }
}
