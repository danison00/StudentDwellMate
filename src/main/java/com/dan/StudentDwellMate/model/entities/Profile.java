package com.dan.StudentDwellMate.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table
public class Profile implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private Occupation occupation;
    private String course;
    private String university;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Andrees_id_fk")
    private Andress endereco;

    @OneToMany(mappedBy = "profile")
    private List<Advertisement> advertisements;
}
