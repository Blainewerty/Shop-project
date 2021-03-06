package ru.milov.shoptest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.milov.shoptest.dto.ProductDto;
import ru.milov.shoptest.service.ProductService;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/shop")
@RequiredArgsConstructor
public class UserController {

    private final ProductService productService;

    @GetMapping("/")
    public List<ProductDto> findAllProducts(){
        return productService.findAll();
    }

    @PostMapping("/{vendorCode}")
    public void buyProduct(@PathVariable String vendorCode,
                           BigDecimal count){
        productService.buyProduct(vendorCode, count);
    }

    @GetMapping("/buyingList")
    public List<ProductDto> buyingList(){
        return productService.findBuyingList();
    }
}
