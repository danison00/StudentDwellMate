package com.dan.StudentDwellMate.model.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Andress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String zipCode;
    private String additionalDetails;

}









