package com.microservice.buybook.buybookmicroservice;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BuyBookSaveDTO implements Serializable {

    private static final long SerialVersionUID = 1L;

    private Long id;
    private String specificID;

    @NotNull
    private String specificIdClient;

    @NotNull
    private List<String> specificIdBooks;

    @NotNull
    private Double amountToPay;

    private LocalDate buyDate;
    private Status status;

}
