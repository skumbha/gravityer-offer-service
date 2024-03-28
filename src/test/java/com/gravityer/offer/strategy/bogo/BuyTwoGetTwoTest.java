package com.gravityer.offer.strategy.bogo;

import com.gravityer.offer.dto.BOGOResponse;
import com.gravityer.offer.dto.Product;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuyTwoGetTwoTest {

    @Test
    public void testMaximizeDiscountEmptyList() {
        List<Product> productList = new ArrayList<>();
        BuyTwoGetTwo bogoOffer = new BuyTwoGetTwo();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);
        assertEquals(0, response.getPayableProducts().size());
        assertEquals(0, response.getDiscountedProducts().size());
    }

    @Test
    public void testMaximizeDiscountSingleProduct() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item1", 50));
        BuyTwoGetTwo bogoOffer = new BuyTwoGetTwo();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);
        assertEquals(1, response.getPayableProducts().size());
        assertEquals(0, response.getDiscountedProducts().size());
    }

    @Test
    public void testMaximizeDiscountMultipleProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item1", 10));
        productList.add(new Product("Item2", 20));
        productList.add(new Product("Item3", 30));
        productList.add(new Product("Item4", 40));
        productList.add(new Product("Item5", 40));
        productList.add(new Product("Item6", 50));
        productList.add(new Product("Item7", 60));
        productList.add(new Product("Item8", 60));
        BuyTwoGetTwo bogoOffer = new BuyTwoGetTwo();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);


        System.out.println(response);

        assertEquals(4, response.getPayableProducts().size());
        assertEquals(4, response.getDiscountedProducts().size());

        assertEquals("Item7", response.getPayableProducts().get(0).getName());
        assertEquals("Item8", response.getPayableProducts().get(1).getName());
        assertEquals("Item5", response.getPayableProducts().get(2).getName());
        assertEquals("Item2", response.getPayableProducts().get(3).getName());

        assertEquals("Item6", response.getDiscountedProducts().get(0).getName());
        assertEquals("Item4", response.getDiscountedProducts().get(1).getName());
        assertEquals("Item3", response.getDiscountedProducts().get(2).getName());
        assertEquals("Item1", response.getDiscountedProducts().get(3).getName());
    }



    @Test
    public void testMaximizeDiscountMultipleProductsSingleItemRemainsInProdListAfterPairing() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item0", 1));

        productList.add(new Product("Item1", 10));
        productList.add(new Product("Item2", 20));
        productList.add(new Product("Item3", 30));
        productList.add(new Product("Item4", 40));
        productList.add(new Product("Item5", 40));
        productList.add(new Product("Item6", 50));
        productList.add(new Product("Item7", 60));
        productList.add(new Product("Item8", 60));
        BuyTwoGetTwo bogoOffer = new BuyTwoGetTwo();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);


        System.out.println(response);

        assertEquals(5, response.getPayableProducts().size());
        assertEquals(4, response.getDiscountedProducts().size());

        assertEquals("Item7", response.getPayableProducts().get(0).getName());
        assertEquals("Item8", response.getPayableProducts().get(1).getName());
        assertEquals("Item5", response.getPayableProducts().get(2).getName());
        assertEquals("Item2", response.getPayableProducts().get(3).getName());
        assertEquals("Item0", response.getPayableProducts().get(4).getName());

        assertEquals("Item6", response.getDiscountedProducts().get(0).getName());
        assertEquals("Item4", response.getDiscountedProducts().get(1).getName());
        assertEquals("Item3", response.getDiscountedProducts().get(2).getName());
        assertEquals("Item1", response.getDiscountedProducts().get(3).getName());
    }

    @Test
    public void testMaximizeDiscountMultipleProducts2ItemRemainsInProdListAfterPairing() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item-1", 1));
        productList.add(new Product("Item0", 2));

        productList.add(new Product("Item1", 10));
        productList.add(new Product("Item2", 20));
        productList.add(new Product("Item3", 30));
        productList.add(new Product("Item4", 40));
        productList.add(new Product("Item5", 40));
        productList.add(new Product("Item6", 50));
        productList.add(new Product("Item7", 60));
        productList.add(new Product("Item8", 60));
        BuyTwoGetTwo bogoOffer = new BuyTwoGetTwo();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);


        System.out.println(response);

        assertEquals(6, response.getPayableProducts().size());
        assertEquals(4, response.getDiscountedProducts().size());

        assertEquals("Item7", response.getPayableProducts().get(0).getName());
        assertEquals("Item8", response.getPayableProducts().get(1).getName());
        assertEquals("Item5", response.getPayableProducts().get(2).getName());
        assertEquals("Item2", response.getPayableProducts().get(3).getName());
        assertEquals("Item0", response.getPayableProducts().get(4).getName());
        assertEquals("Item-1", response.getPayableProducts().get(5).getName());

        assertEquals("Item6", response.getDiscountedProducts().get(0).getName());
        assertEquals("Item4", response.getDiscountedProducts().get(1).getName());
        assertEquals("Item3", response.getDiscountedProducts().get(2).getName());
        assertEquals("Item1", response.getDiscountedProducts().get(3).getName());

    }

    @Test
    public void testMaximizeDiscountMultipleProducts3ItemRemainsInProdListAfterPairing() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item-2", 1));
        productList.add(new Product("Item-1", 2));
        productList.add(new Product("Item0", 3));

        productList.add(new Product("Item1", 10));
        productList.add(new Product("Item2", 20));
        productList.add(new Product("Item3", 30));
        productList.add(new Product("Item4", 40));
        productList.add(new Product("Item5", 40));
        productList.add(new Product("Item6", 50));
        productList.add(new Product("Item7", 60));
        productList.add(new Product("Item8", 60));
        BuyTwoGetTwo bogoOffer = new BuyTwoGetTwo();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);


        System.out.println(response);

        assertEquals(6, response.getPayableProducts().size());
        assertEquals(5, response.getDiscountedProducts().size());

        assertEquals("Item7", response.getPayableProducts().get(0).getName());
        assertEquals("Item8", response.getPayableProducts().get(1).getName());
        assertEquals("Item5", response.getPayableProducts().get(2).getName());
        assertEquals("Item2", response.getPayableProducts().get(3).getName());
        assertEquals("Item0", response.getPayableProducts().get(4).getName());
        assertEquals("Item-1", response.getPayableProducts().get(5).getName());

        assertEquals("Item6", response.getDiscountedProducts().get(0).getName());
        assertEquals("Item4", response.getDiscountedProducts().get(1).getName());
        assertEquals("Item3", response.getDiscountedProducts().get(2).getName());
        assertEquals("Item1", response.getDiscountedProducts().get(3).getName());
        assertEquals("Item-2", response.getDiscountedProducts().get(4).getName());
    }

    @Test
    public void testMaximizeDiscountMultipleProductsV2() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Item1", 5));
        productList.add(new Product("Item2", 5));
        productList.add(new Product("Item3", 10));
        productList.add(new Product("Item4", 20));
        productList.add(new Product("Item5", 30));
        productList.add(new Product("Item6", 40));
        productList.add(new Product("Item7", 50));
        productList.add(new Product("Item8", 50));
        productList.add(new Product("Item9", 50));
        productList.add(new Product("Item10", 60));
        BuyTwoGetTwo bogoOffer = new BuyTwoGetTwo();
        BOGOResponse response = bogoOffer.maximizeDiscount(productList);


        System.out.println(response);

        assertEquals(6, response.getPayableProducts().size());
        assertEquals(4, response.getDiscountedProducts().size());

        assertEquals("Item10", response.getPayableProducts().get(0).getName());
        assertEquals("Item8", response.getPayableProducts().get(1).getName());
        assertEquals("Item9", response.getPayableProducts().get(2).getName());
        assertEquals("Item4", response.getPayableProducts().get(3).getName());
        assertEquals("Item1", response.getPayableProducts().get(4).getName());
        assertEquals("Item2", response.getPayableProducts().get(5).getName());

        assertEquals("Item7", response.getDiscountedProducts().get(0).getName());
        assertEquals("Item6", response.getDiscountedProducts().get(1).getName());
        assertEquals("Item5", response.getDiscountedProducts().get(2).getName());
        assertEquals("Item3", response.getDiscountedProducts().get(3).getName());
    }

}