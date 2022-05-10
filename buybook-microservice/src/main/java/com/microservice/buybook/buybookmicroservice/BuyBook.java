package com.microservice.buybook.buybookmicroservice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "buyBook")
public class BuyBook implements Serializable {

    private static final long SerialVersionUID = 1L;

    @Id
    @Column(name = "buyBook_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double amountToPay;
    private LocalDate buyDate;

    private String specificIdClient;
    private String specificIdBooks;
    private String specificID;

    @Enumerated(value = EnumType.STRING)
    private Status status;

    public static BuyBook to(BuyBookSaveDTO dto, String specificIdBooks) {
        return BuyBook
                .builder()
                .specificIdClient(dto.getSpecificIdClient())
                .specificIdBooks(specificIdBooks)
                .amountToPay(dto.getAmountToPay())
                .status(dto.getStatus())
                .buyDate(dto.getBuyDate())
                .specificID(dto.getSpecificID())
                .build();

    }
}
