package com.gravityer.offer.strategy.bogo;

import com.gravityer.offer.dto.BOGOResponse;
import com.gravityer.offer.dto.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyOneGetOneTest {

    @Test
    void testMaximizeDiscountEmptyList() {
        List<Product> productList = new ArrayList<>();
        IBOGOOffer bogoOffer = new BuyOneGetOne();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);
        assertEquals(0, response.getPayableProducts().size());
        assertEquals(0, response.getDiscountedProducts().size());
    }

    @Test
    void testMaximizeDiscountSingleProduct() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item1", 50));
        IBOGOOffer bogoOffer = new BuyOneGetOne();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);
        assertEquals(1, response.getPayableProducts().size());
        assertEquals(0, response.getDiscountedProducts().size());
    }

    @Test
    void testMaximizeDiscountSingleProduct0() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item1", 20));
        productList.add(new Product("Item2", 50));

        IBOGOOffer bogoOffer = new BuyOneGetOne();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);
        assertEquals(1, response.getPayableProducts().size());
        assertEquals(1, response.getDiscountedProducts().size());

        assertEquals("Item2", response.getPayableProducts().get(0).getName());

        assertEquals("Item1", response.getDiscountedProducts().get(0).getName());
    }

    @Test
    void testMaximizeDiscountMultipleProducts1() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item1", 10));
        productList.add(new Product("Item2", 20));
        productList.add(new Product("Item3", 30));
        productList.add(new Product("Item4", 40));
        productList.add(new Product("Item5", 50));
        productList.add(new Product("Item6", 60));
        IBOGOOffer bogoOffer = new BuyOneGetOne();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);

        //System.out.println(response);

        assertEquals(3, response.getPayableProducts().size());
        assertEquals(3, response.getDiscountedProducts().size());

        assertEquals("Item6", response.getPayableProducts().get(0).getName());
        assertEquals("Item4", response.getPayableProducts().get(1).getName());
        assertEquals("Item2", response.getPayableProducts().get(2).getName());

        assertEquals("Item5", response.getDiscountedProducts().get(0).getName());
        assertEquals("Item3", response.getDiscountedProducts().get(1).getName());
        assertEquals("Item1", response.getDiscountedProducts().get(2).getName());
    }

    @Test
    void testMaximizeDiscountMultipleProducts2() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item1", 10));
        productList.add(new Product("Item2", 20));
        productList.add(new Product("Item3", 30));
        productList.add(new Product("Item4", 40));
        productList.add(new Product("Item5", 50));
        productList.add(new Product("Item6", 50));
        productList.add(new Product("Item7", 60));
        IBOGOOffer bogoOffer = new BuyOneGetOne();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);

        //System.out.println(response);

        assertEquals(4, response.getPayableProducts().size());
        assertEquals(3, response.getDiscountedProducts().size());

        assertEquals("Item7", response.getPayableProducts().get(0).getName());
        assertEquals("Item6", response.getPayableProducts().get(1).getName());
        assertEquals("Item3", response.getPayableProducts().get(2).getName());
        assertEquals("Item1", response.getPayableProducts().get(3).getName());

        assertEquals("Item5", response.getDiscountedProducts().get(0).getName());
        assertEquals("Item4", response.getDiscountedProducts().get(1).getName());
        assertEquals("Item2", response.getDiscountedProducts().get(2).getName());
    }


    //@Test
    void testMaximizeDiscountMultipleProducts3() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item1", 10));
        productList.add(new Product("Item2", 20));
        productList.add(new Product("Item3", 30));
        productList.add(new Product("Item4", 40));
        productList.add(new Product("Item5", 60));
        productList.add(new Product("Item6", 50));
        productList.add(new Product("Item7", 70));
        productList.add(new Product("Item7", 70));
        IBOGOOffer bogoOffer = new BuyOneGetOne();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);

        System.out.println(response);


    }
}
