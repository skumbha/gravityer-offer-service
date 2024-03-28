package com.gravityer.offer.controller;

import com.gravityer.offer.dto.BOGOResponse;
import com.gravityer.offer.dto.Product;
import com.gravityer.offer.service.BOGOCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class BOGOController {

    final BOGOCalculatorService bogoCalculatorService;

    public BOGOController(BOGOCalculatorService bogoCalculatorService) {
        this.bogoCalculatorService = bogoCalculatorService;
    }

    @PostMapping("/v1/calculate-bogo")
    public BOGOResponse calculateBOGO(@RequestBody List<Product> products, @RequestParam("bogoType") String bogoType) {
        return bogoCalculatorService.calculateBOGO(products,bogoType);
    }

}
