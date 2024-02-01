package com.dan.StudentDwellMate.model.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
@Entity
@Table
public class Property implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "id_fk_profile")
    private Profile profile;

    private String city;
    private String state;
    private String street;
    private String neighborhood;
    private String houseNumber;
    private String additionalDetails;
    private String postalCode;

    List<String> propertyPhoto;
    
}









