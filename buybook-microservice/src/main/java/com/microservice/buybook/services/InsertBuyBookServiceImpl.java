package com.microservice.buybook.services;

import com.microservice.buybook.buybookmicroservice.*;
import com.microservice.buybook.exceptions.ObjectNotFoundException;
import com.microservice.buybook.feign.EndpointBookFeignClient;
import com.microservice.buybook.feign.EndpointClientFeignClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class InsertBuyBookServiceImpl implements InsertBuyBookService{

    private final BuyBookRepository buyBookRepository;
    private final EndpointBookFeignClient feignGetBook;
    private final EndpointClientFeignClient feignGetClient;

    @Override
    public void insert(BuyBookSaveDTO buyBookSaveDTO){

            String booksID = "";
            try {
                feignGetClient.findSpecificID(buyBookSaveDTO.getSpecificIdClient());
            } catch (FeignException.NotFound requisition){
                throw new ObjectNotFoundException(requisition.getMessage());
            }

            try {
                for (String books: buyBookSaveDTO.getSpecificIdBooks()){
                    feignGetBook.findSpecificID(books); booksID += books; booksID += ",";
                }
            } catch (FeignException.NotFound requisition){
                throw new ObjectNotFoundException(requisition.getMessage());
            }

            buyBookSaveDTO.setStatus(Status.PENDING);


            BuyBook buyBook = BuyBook.to(buyBookSaveDTO, booksID);

            buyBookRepository.save(buyBook);
        }
    }


