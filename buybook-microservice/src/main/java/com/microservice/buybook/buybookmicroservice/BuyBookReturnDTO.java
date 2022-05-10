package com.microservice.buybook.buybookmicroservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BuyBookReturnDTO implements Serializable {

    private static final long SerialVersionUID = 1L;

    private Long id;
    private String specificID;

    private ClientDTO clientDTO;

    private List <BookDTO> books;

    private Double amountToPay;
    private LocalDate buyDate;
    private Status status;


    public static BuyBookReturnDTO from(BuyBook dto, ClientDTO clientDTO, List<BookDTO> books) {
        return BuyBookReturnDTO
                .builder()
                .id(dto.getId())
                .clientDTO(clientDTO)
                .books(books)
                .amountToPay(dto.getAmountToPay())
                .buyDate(dto.getBuyDate())
                .status(dto.getStatus())
                .build();
    }
}

