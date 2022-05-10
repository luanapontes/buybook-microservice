package com.microservice.buybook.services;

import com.microservice.buybook.buybookmicroservice.BuyBookRepository;
import com.microservice.buybook.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteBuyBookServiceImpl implements DeleteBuyBookService{

    private final BuyBookRepository buyBookRepository;

    @Override
    public void delete(Long id){
        if(!buyBookRepository.existsById(id)){
            throw new ObjectNotFoundException("Object not found");
        }

        buyBookRepository.deleteById(id);
    }
}
