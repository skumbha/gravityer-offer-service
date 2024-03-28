package com.gravityer.offer.strategy.bogo;

import com.gravityer.offer.dto.BOGOResponse;
import com.gravityer.offer.dto.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Offer Rule 2:  Customers can buy one product and get another product for free as long as the price of the product is less than the price of the corresponding product in pairs.
 *
 * Example 1 :
 * Input:
 * Product Price List = [ 10,20,30,40,40,50,60,60 ]
 * Output:
 * Discounted Items = [50,40,30,10]
 * Payable Items = [60,60,40, 20]
 *
 * Example 2:
 * Input:
 * Product Price List = [ 10,20,30,40,50,50,50,60 ]
 * Output:
 * Discounted Items = [50,40,30,10]
 * Payable Items = [60,50,50,,20]
 */
@Component("BuyOneGetOneV2")
public class BuyOneGetOneV2 implements IBOGOOffer {

    @Override
    public BOGOResponse maximizeDiscount(List<Product> productList) {
        productList.sort((p1, p2) -> Integer.compare(p2.getPrice(), p1.getPrice()));

        List<Product> payableProducts = new ArrayList<>();
        List<Product> discountedProducts = new ArrayList<>();

        Stack<Product> productStack = new Stack<>();

        Product currentProduct = null;
        for (int i = 0; i < productList.size();i++) {

            if(currentProduct==null){
                currentProduct = productList.get(i);
                continue;
            }
            if(currentProduct.getPrice() == productList.get(i).getPrice()){
                productStack.push(productList.get(i));
            }else {
                payableProducts.add(currentProduct);
                discountedProducts.add(productList.get(i));
                if(productStack.isEmpty()){
                    currentProduct = null;
                }else {
                    currentProduct = productStack.pop();
                }
            }
        }

        if(currentProduct!=null){
            payableProducts.add(currentProduct);
        }

        return new BOGOResponse(payableProducts, discountedProducts);
    }

    @Override
    public String getName() {
        return "BuyOneGetOneV2";
    }
}
