package com.example.mapstruct.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class ProductDto {

    
    @Id
    private int id;
    private String name;
    private String description;
    private String quantity;
    private Long price;
    private String itemId;


}
