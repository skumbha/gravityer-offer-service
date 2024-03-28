package com.gravityer.offer.strategy.bogo;

import com.gravityer.offer.dto.BOGOResponse;
import com.gravityer.offer.dto.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Offer Rules: Customers can buy one product and get another product for free as long as the price of the product is equal to or less than the price of the first product.
 * Input:
 * Product Price List = [ 10,20,30,40,50,60 ]
 * Output:
 * Discounted Items = [50,30,10]
 * Payable Items = [60,40,20]
 *
 * Example 2:
 * Input:
 * Product Price List = [ 10,20,30,40,50,50,60 ]
 * Output:
 * Discounted Items = [50,40,20]
 * Payable Items = [60,50, 30,10]
 *
 */
@Component("BuyOneGetOne")
public class BuyOneGetOne implements IBOGOOffer {

    @Override
    public BOGOResponse maximizeDiscount(List<Product> productList) {
        productList.sort((p1, p2) -> Integer.compare(p2.getPrice(), p1.getPrice()));

        List<Product> payableProducts = new ArrayList<>();
        List<Product> discountedProducts = new ArrayList<>();

        for (int i = 0; i < productList.size(); i++) {
            Product currentProduct = productList.get(i);
            if (i + 1 < productList.size() && productList.get(i + 1).getPrice() <= currentProduct.getPrice()) {
                payableProducts.add(currentProduct);
                discountedProducts.add(productList.get(i + 1));
                i++;
            } else {
                payableProducts.add(currentProduct);
            }
        }

        return new BOGOResponse(payableProducts, discountedProducts);
    }

    @Override
    public String getName() {
        return "BuyOneGetOne";
    }
}
