package com.gravityer.offer.service;

import com.gravityer.offer.dto.BOGOResponse;
import com.gravityer.offer.dto.Product;
import com.gravityer.offer.exception.OfferServiceRuntimeException;
import com.gravityer.offer.strategy.bogo.IBOGOOffer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BOGOCalculatorService {

    private final Map<String, IBOGOOffer> bogoOfferMap = new HashMap<>();

    @Autowired
    public BOGOCalculatorService(List<IBOGOOffer> bogoOffers) {
        bogoOffers.forEach(offer->{
            bogoOfferMap.put(offer.getName(),offer);
        });
    }

    public BOGOResponse calculateBOGO(List<Product> products, String bogoType) {
        IBOGOOffer bogoOffer = bogoOfferMap.get(bogoType);
        if (bogoOffer != null) {
            return bogoOffer.maximizeDiscount(products);
        } else {
            throw new OfferServiceRuntimeException(1001,"Invalid BOGO type");
        }
    }
}