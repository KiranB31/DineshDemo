package com.example.mapstruct.entity;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotBlank
    @Size(min = 3 ,message = "name should have minimum 3 characters")
    @Column(name ="name")
    private String name;

    @NotBlank
    @Size(min = 3 ,message = "description should have minimum 3 characters")
    @Column(name ="description")
    private String description;


    private int quantity;


    private Long price;


    private String itemId;




}
