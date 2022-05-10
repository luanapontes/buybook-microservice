package com.microservice.buybook.services;

import com.microservice.buybook.buybookmicroservice.BuyBook;
import com.microservice.buybook.buybookmicroservice.BuyBookReturnDTO;
import com.microservice.buybook.buybookmicroservice.BuyBookRepository;
import com.microservice.buybook.buybookmicroservice.Status;
import com.microservice.buybook.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateBuyBookImpl implements UpdateBuyBookService{

    private final BuyBookRepository buyBookRepository;

    @Override
    public void update(BuyBookReturnDTO buyBookDTO, Long id){
        BuyBook buyBookSaved = buyBookRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Object not found"));
        buyBookSaved.setStatus(Status.DONE);
        buyBookRepository.save(buyBookSaved);

    }
}
