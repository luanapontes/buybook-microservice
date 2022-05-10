package com.microservice.buybook.buybookmicroservice;

import lombok.*;
import org.springframework.data.domain.Page;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO implements Serializable {

    private static final long SerialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "The category name cannot be empty")
    private String name;
}
