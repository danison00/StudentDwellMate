package com.dan.StudentDwellMate.model.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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

        @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL)
        private List<ConnectionRequest> resquestsConnectionSent;
        
        @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
        private List<ConnectionRequest> resquestsConnectionReceived;

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

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((id == null) ? 0 : id.hashCode());
                result = prime * result + ((name == null) ? 0 : name.hashCode());
                result = prime * result + ((faculty == null) ? 0 : faculty.hashCode());
                result = prime * result + ((course == null) ? 0 : course.hashCode());
                result = prime * result + age;
                result = prime * result + ((email == null) ? 0 : email.hashCode());
                result = prime * result + ((instagram == null) ? 0 : instagram.hashCode());
                result = prime * result + ((facebook == null) ? 0 : facebook.hashCode());
                result = prime * result + ((whatsapp == null) ? 0 : whatsapp.hashCode());
                result = prime * result + ((profilePhotoUrl == null) ? 0 : profilePhotoUrl.hashCode());
                result = prime * result + (hasRentedProperty ? 1231 : 1237);
                result = prime * result + ((cityOrigin == null) ? 0 : cityOrigin.hashCode());
                result = prime * result + (wantsToSharedProperty ? 1231 : 1237);
                result = prime * result + ((property == null) ? 0 : property.hashCode());
                return result;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                Profile other = (Profile) obj;
                if (id == null) {
                        if (other.id != null)
                                return false;
                } else if (!id.equals(other.id))
                        return false;
                if (name == null) {
                        if (other.name != null)
                                return false;
                } else if (!name.equals(other.name))
                        return false;
                if (faculty == null) {
                        if (other.faculty != null)
                                return false;
                } else if (!faculty.equals(other.faculty))
                        return false;
                if (course == null) {
                        if (other.course != null)
                                return false;
                } else if (!course.equals(other.course))
                        return false;
                if (age != other.age)
                        return false;
                if (email == null) {
                        if (other.email != null)
                                return false;
                } else if (!email.equals(other.email))
                        return false;
                if (instagram == null) {
                        if (other.instagram != null)
                                return false;
                } else if (!instagram.equals(other.instagram))
                        return false;
                if (facebook == null) {
                        if (other.facebook != null)
                                return false;
                } else if (!facebook.equals(other.facebook))
                        return false;
                if (whatsapp == null) {
                        if (other.whatsapp != null)
                                return false;
                } else if (!whatsapp.equals(other.whatsapp))
                        return false;
                if (profilePhotoUrl == null) {
                        if (other.profilePhotoUrl != null)
                                return false;
                } else if (!profilePhotoUrl.equals(other.profilePhotoUrl))
                        return false;
                if (hasRentedProperty != other.hasRentedProperty)
                        return false;
                if (cityOrigin == null) {
                        if (other.cityOrigin != null)
                                return false;
                } else if (!cityOrigin.equals(other.cityOrigin))
                        return false;
                if (wantsToSharedProperty != other.wantsToSharedProperty)
                        return false;
                if (property == null) {
                        if (other.property != null)
                                return false;
                } else if (!property.equals(other.property))
                        return false;
                return true;
        }

       
        

}
