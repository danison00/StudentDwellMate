package com.dan.StudentDwellMate.model.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table
@Entity
public class Profile implements Serializable{

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String faculty;
        @Column(length = 40)
        private String course;
        private int age;
        @Column(unique = true)
        private String email;
        private String instagram;
        private String facebook;
        private String whatsapp;
        private String profilePhotoUrl;
        private boolean hasRentedProperty;
        private String cityOrigin;
        private boolean wantsToSharedProperty;

        @OneToOne(mappedBy = "profile", cascade = CascadeType.ALL)
        private Property property;

        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "connection_requests", joinColumns = @JoinColumn(name = "id_fk_sender_profile"), inverseJoinColumns = @JoinColumn(name = "id_fk_receiver_profile"))
        private Set<Profile> connectionRequest;

        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "connections", joinColumns = @JoinColumn(name = "id_fk_profile"), inverseJoinColumns = @JoinColumn(name = "id_fk_profile_connected"))
        private Set<Profile> connections;// = new HashSet<>();

        @ManyToMany(cascade = CascadeType.ALL)
        @JoinTable(name = "blocked", joinColumns = @JoinColumn(name = "id_fk_profile"), inverseJoinColumns = @JoinColumn(name = "id_fk_blocked_profile"))
        private Set<Profile> blocked;// = new HashSet<>();

        public Profile(String name, String faculty, String course, int age, String email, String instagram,
                        String facebook, String whatsapp, String profilePhotoUrl, boolean hasRentedProperty,
                        String cityOrigin,
                        boolean wantsToSharedProperty, Property property) {
                this.name = name;
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
