package ru.milov.shoptest.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.milov.shoptest.dto.ProductDto;
import ru.milov.shoptest.entity.Product;
import ru.milov.shoptest.entity.Shipment;
import ru.milov.shoptest.entity.User;
import ru.milov.shoptest.mappers.ProductMapper;
import ru.milov.shoptest.repository.ProductRepository;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final UserService userService;

    private final ShipmentService shipmentService;

    @Transactional(readOnly = true)
    public List<ProductDto> findAll() {
        return productRepository.findAll().stream()
                .map(ProductMapper.INSTANCE::toDto).collect(Collectors.toList());
    }

    private Product getProduct(String vendorCode){
        return productRepository.findByVendorCode(vendorCode);
    }

    public void addProduct(Product product, Shipment shipments) {
        product.setShipments(Collections.singletonList(shipments));
        productRepository.save(product);
    }

    public void buyProduct(String vendorCode, BigDecimal count) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Product product = getProduct(vendorCode);
        product.setUser(user);
        Optional<Shipment> optional = product.getShipments().stream().map(i -> i.setWeight(i.getWeight().subtract(count))).findFirst();
        Shipment shipment = optional.orElse(null);
        shipmentService.updateShipment(shipment);
    }

    public void deleteProduct(Product product) {
        Product productFromDb = productRepository.findByVendorCode(product.getVendorCode());
        productRepository.delete(productFromDb.getVendorCode());
    }

    public void updateProduct(Product product, String vendorCode) {
        Product productFromDB = getProduct(vendorCode);
        if(product.getPrice() != null) productFromDB.setPrice(product.getPrice());
        if(product.getName() != null) productFromDB.setName(product.getName());
        productRepository.save(productFromDB);

    }

    public List<ProductDto> findBuyingList() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return productRepository.findByUser(user)
                .stream()
                .map(ProductMapper.INSTANCE::toDto).collect(Collectors.toList());
    }
}
