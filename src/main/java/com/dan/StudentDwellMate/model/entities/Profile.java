package com.dan.StudentDwellMate.model.entities;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor @Builder
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="property_id_fk")
    private Property property;

 
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "receiverSenderConnections",
            joinColumns = @JoinColumn(name = "receiver_profile_id"),
            inverseJoinColumns = @JoinColumn(name = "sender_profile_id")
    )
    private Set<Profile> receiverSenderConnections = new HashSet<>();
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "connections",
            joinColumns = @JoinColumn(name = "connection_1_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "connection_2_id_fk")
    )
    private Set<Profile> connections = new HashSet<>();

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "blocked",
            joinColumns = @JoinColumn(name = "profile_id_fk"),
            inverseJoinColumns = @JoinColumn(name = "blocked_profile_id_fk")
    )
    private Set<Profile> blocked = new HashSet<>();

public Profile(String name, String cpf, String faculty, String course, int age, String email, String instagram,
                String facebook, String whatsapp, String profilePhotoUrl, boolean hasRentedProperty, String cityOrigin,
                boolean wantsToSharedProperty, Property property) {
        this.name = name;
        this.cpf = cpf;
        this.faculty = faculty;
        this.course = course;
        this.age = age;
        this.email = email;
        this.instagram = instagram;
        this.facebook = facebook;
        this.whatsapp = whatsapp;
        this.profilePhotoUrl = profilePhotoUrl;
        this.hasRentedProperty = hasRentedProperty;
        this.cityOrigin = cityOrigin;
        this.wantsToSharedProperty = wantsToSharedProperty;
        this.property = property;
}

    
}
