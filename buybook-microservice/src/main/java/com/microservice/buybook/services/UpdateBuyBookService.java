package com.microservice.buybook.services;

import com.microservice.buybook.buybookmicroservice.BuyBookReturnDTO;


public interface UpdateBuyBookService {

    public void update(BuyBookReturnDTO buyBookDTO, Long id);
}
