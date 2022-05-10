package com.microservice.buybook.services;


import com.microservice.buybook.buybookmicroservice.*;
import com.microservice.buybook.exceptions.ObjectNotFoundException;
import com.microservice.buybook.feign.EndpointBookFeignClient;
import com.microservice.buybook.feign.EndpointClientFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class FindByIdBuyBookServiceImpl implements FindByIdBuyBookService {

    private final BuyBookRepository buyBookRepository;
    private final EndpointBookFeignClient feignGetBook;
    private final EndpointClientFeignClient feignGetClient;

    @Override
    public BuyBookReturnDTO findById(Long id) {
        BuyBook buyBook = buyBookRepository.findById(id).orElseThrow(
                () ->
                        new ObjectNotFoundException("Object not found"));
        ClientDTO clientDTO = feignGetClient.findSpecificID(buyBook.getSpecificIdClient());
        String[] purchasedBookID = buyBook.getSpecificIdBooks().split(",");
        List<BookDTO> buyBooksFound = new ArrayList<>();
        for(String book: purchasedBookID) {
            buyBooksFound.add(feignGetBook.findSpecificID(book));
        }
        return BuyBookReturnDTO.from(buyBook, clientDTO, buyBooksFound);
    }
}
