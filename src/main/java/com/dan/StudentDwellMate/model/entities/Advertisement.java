package com.dan.StudentDwellMate.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table
public class Advertisement implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    
    @Column(columnDefinition = "Date")
    LocalDate date;
    private double price;
    
    private String propertyType;
    
    private String neighbors;
    
    @ElementCollection
    private List<String> houseRules;
    
    private String advertiserInfo;
    
    private boolean seekingCoTenant;
    
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "profile_id_fk")
    private Profile profile;




}
