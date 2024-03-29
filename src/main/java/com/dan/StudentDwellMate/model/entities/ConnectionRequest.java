package com.dan.StudentDwellMate.model.entities;

import java.time.LocalDateTime;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@AllArgsConstructor
@Table(name = "connection_request")
@Entity
public class ConnectionRequest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "id_fk_profile_sender")
    private Profile sender;

    @ManyToOne()
    @JoinColumn(name = "id_fk_profile_receiver")
    private Profile receiver;

    private LocalDateTime date;

    public ConnectionRequest(Profile sender, Profile receiver) {
        this.sender = sender;
        this.receiver = receiver;
        this.date = LocalDateTime.now();
    }


}
