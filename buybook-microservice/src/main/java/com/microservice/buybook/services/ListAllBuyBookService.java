package com.microservice.buybook.services;

import com.microservice.buybook.buybookmicroservice.BuyBook;
import com.microservice.buybook.buybookmicroservice.BuyBookReturnDTO;

import java.util.List;

public interface ListAllBuyBookService {
     List<BuyBookReturnDTO> listAll();
}
