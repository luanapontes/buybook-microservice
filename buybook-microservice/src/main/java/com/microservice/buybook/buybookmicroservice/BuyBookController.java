package com.microservice.buybook.buybookmicroservice;

import com.microservice.buybook.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/buybooks")
public class BuyBookController {

    private final DeleteBuyBookService deleteBuyBookService;
    private final FindByIdBuyBookService findByIdBuyBookService;
    private final InsertBuyBookService insertBuyBookService;
    private final ListAllBuyBookService listAllBuyBookService;
    private final UpdateBuyBookService updateBuyBookService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BuyBookReturnDTO> listAll(){
        return listAllBuyBookService.listAll();
    }

    @GetMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BuyBookReturnDTO findById(@PathVariable(value="id") Long id){
        return findByIdBuyBookService.findById(id);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    public void insert(@Valid @RequestBody BuyBookSaveDTO buyBookDTO) {
        insertBuyBookService.insert(buyBookDTO);
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PutMapping(value = "/{id}")
    public void update(@RequestBody BuyBookReturnDTO buyBookDTO, @PathVariable Long id){
        updateBuyBookService.update(buyBookDTO, id);
    }
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id){
        deleteBuyBookService.delete(id);
    }
}
