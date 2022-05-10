package com.microservice.buybook.services;

import com.microservice.buybook.buybookmicroservice.BuyBookSaveDTO;

@FunctionalInterface
public interface InsertBuyBookService {

    void insert(BuyBookSaveDTO buyBookSaveDTO);
}
