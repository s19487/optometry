package com.baranskagata.optometry.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @OneToMany(mappedBy ="patient", cascade = CascadeType.ALL)
    private List<Appointment> appointmentList;

    @OneToOne()
    @JoinColumn(name="user_id")
    private AppUser appUser;

}
