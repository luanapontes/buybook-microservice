package com.microservice.buybook.services.utils;

import com.microservice.buybook.buybookmicroservice.BookDTO;
import com.microservice.buybook.buybookmicroservice.BuyBook;
import com.microservice.buybook.feign.EndpointBookFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReturnSetBooksOfFeign {

    private final EndpointBookFeignClient feignGetBook;

    public List<BookDTO> findAllFeign(BuyBook buyBook) {
        String[] purchasedBookID = buyBook.getSpecificIdBooks().split(",");
        List<BookDTO> buyBooksFound = new ArrayList<>();
        for(String book: purchasedBookID) {
            buyBooksFound.add(feignGetBook.findSpecificID(book));
        }
        return buyBooksFound;
    }
}
