package com.gravityer.offer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data @AllArgsConstructor @NoArgsConstructor
public class BOGOResponse {

    private List<Product> payableProducts;
    private List<Product> discountedProducts;

}
