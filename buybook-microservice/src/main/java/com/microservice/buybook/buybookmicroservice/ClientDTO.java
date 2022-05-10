package com.microservice.buybook.buybookmicroservice;

import lombok.*;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDTO implements Serializable {

    private static final long SerialVersionUID = 1L;

    private Long id;
    @NotEmpty(message = "The client name cannot be empty")
    private String name;

    @NotNull(message = "The client age cannot be null")
    private Integer age;

    @NotEmpty(message = "The client contact cannot be empty")
    private String contact;

    @NotEmpty(message = "The client email cannot be empty")
    private String email;

    @NotNull(message = "The client gender cannot be null")
    private char gender;

    private String specificID;
}
