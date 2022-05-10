package com.microservice.buybook.buybookmicroservice;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO implements Serializable {

    private static final long SerialVersionUID = 1L;

    private Long id;

    @NotNull
    private String name;

    @Size(max = 500)
    @NotNull
    private String resume;

    @Size(min = 17)
    @NotNull
    private Integer isbn;

    @Size(min = 1)
    @NotNull
    private String author;

    @NotNull
    private Integer yearOfPublication;

    @Min(0)
    @NotNull
    private Double sellPrice;

    @NotNull
    private Integer quantityAvailable;

    private String specificID;

    @NotNull
    private List<CategoryDTO> categories = new ArrayList<>();

}
