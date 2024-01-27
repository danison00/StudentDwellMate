package com.dan.StudentDwellMate.model.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor
@Table
@Entity
public class Profile {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf;
    private String faculty;
    private String course;
    private int age;
    private String email;
    private String instagram;
    private String facebook;
    private String whatsapp;
    private String profilePhotoUrl;
    private boolean hasRentedProperty;
    private String cityOrigin;
    private boolean wantsToSharedProperty;

    // private List<ProfileEnc> sendRequests;
    // private List<ProfileEnc> receivedRequests;
    // private List<ProfileEnc> blockeds;

    @ManyToMany
    @JoinTable(
            name = "receiverSenderConnections",
            joinColumns = @JoinColumn(name = "receiver_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "sender_profile_id")
    )
    private Set<Profile> receiverSenderConnections = new HashSet<>();
}
