package com.saurabhsomani.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)

    @JsonProperty("ID")
    private Long id;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Price")
    private int price;

    @JsonProperty("SalesCount")
    private int salesCount;

    @JsonProperty("Category")
    private String category;

    @JsonProperty("Cust_Rating")
    private double custRating;

    public Product(){

    }
}
