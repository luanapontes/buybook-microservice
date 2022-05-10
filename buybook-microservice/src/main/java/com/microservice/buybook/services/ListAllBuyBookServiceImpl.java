package com.microservice.buybook.services;

import com.microservice.buybook.buybookmicroservice.BuyBook;
import com.microservice.buybook.buybookmicroservice.BuyBookRepository;
import com.microservice.buybook.buybookmicroservice.BuyBookReturnDTO;
import com.microservice.buybook.services.utils.ReturnAllBuyBook;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ListAllBuyBookServiceImpl implements ListAllBuyBookService{

    private final BuyBookRepository buyBookRepository;
    private final ReturnAllBuyBook returnAllBuyBook;

    @Override
    public List<BuyBookReturnDTO> listAll(){
        return returnAllBuyBook.findAllBuyBook();
    }
}
