package com.gravityer.offer.strategy.bogo;

import com.gravityer.offer.dto.BOGOResponse;
import com.gravityer.offer.dto.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Rule: Customers can buy two products and get two products for free as long as the price of the product is less than the price of the first product.
 *
 * Example1:
 * Input:
 * Product Price List = [ 10,20,30,40,40,50,60,60 ]
 * Output:
 * Discounted Items = [50,40,30,10]
 * Payable Items = [60,60,40, 20]
 *
 * Example1:
 * Input:
 * Product Price List = [ 5,5,10,20,30,40,50,50,50,60 ]
 * Output:
 * Discounted Items = [50,40,30,10]
 * Payable Items = [60,50,50,,20,5,5]
 */
@Component("BuyTwoGetTwo")
public class BuyTwoGetTwo implements IBOGOOffer {

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

                if((payableProducts.size()+discountedProducts.size())%4 == 0){
                    if((productList.size()-i-1) == 1){
                        //System.out.println("1 item remain");
                        payableProducts.add(productList.get(i+1));
                        currentProduct = null;
                        break;
                    }

                    if((productList.size()-i-1) == 2){
                        //System.out.println("2 item remain");
                        payableProducts.add(productList.get(i+1));
                        payableProducts.add(productList.get(i+2));
                        currentProduct = null;
                        break;
                    }

                    if((productList.size()-i-1) == 3){
                        //System.out.println("3 item remain");
                        payableProducts.add(productList.get(i+1));
                        payableProducts.add(productList.get(i+2));
                        discountedProducts.add(productList.get(i+3));
                        currentProduct = null;
                        break;
                    }
                }

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
        return "BuyTwoGetTwo";
    }

}