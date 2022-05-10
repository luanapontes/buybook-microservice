package com.microservice.buybook.services;

import com.microservice.buybook.buybookmicroservice.BuyBookReturnDTO;


public interface FindByIdBuyBookService {

    BuyBookReturnDTO findById(Long id);
}
