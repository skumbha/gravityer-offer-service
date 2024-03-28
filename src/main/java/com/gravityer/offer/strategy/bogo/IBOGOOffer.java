package com.gravityer.offer.strategy.bogo;

import com.gravityer.offer.dto.BOGOResponse;
import com.gravityer.offer.dto.Product;

import java.util.List;

public interface IBOGOOffer {

    BOGOResponse maximizeDiscount(List<Product> productList);

    String getName();

}
