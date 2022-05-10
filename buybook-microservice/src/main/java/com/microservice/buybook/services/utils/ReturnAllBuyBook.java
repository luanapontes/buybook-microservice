package com.microservice.buybook.services.utils;

import com.microservice.buybook.buybookmicroservice.*;
import com.microservice.buybook.feign.EndpointBookFeignClient;
import com.microservice.buybook.feign.EndpointClientFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReturnAllBuyBook {

    private final BuyBookRepository buyBookRepository;
    private final ReturnSetBooksOfFeign returnSetBooksOfFeign;
    private final EndpointBookFeignClient feignGetBook;
    private final EndpointClientFeignClient feignGetClient;

    public List<BuyBookReturnDTO> findAllBuyBook() {
        List<BuyBookReturnDTO> buyBookReturnDTOS = new ArrayList<>();
        for(BuyBook buyBook: buyBookRepository.findAll()){
            ClientDTO clientDTO = feignGetClient.findSpecificID(buyBook.getSpecificIdClient());
            List<BookDTO> bookDTOSet;
            bookDTOSet = returnSetBooksOfFeign.findAllFeign(buyBook);
            buyBookReturnDTOS.add(BuyBookReturnDTO.from(buyBook, clientDTO, bookDTOSet));
        }
        return buyBookReturnDTOS;
    }
}
