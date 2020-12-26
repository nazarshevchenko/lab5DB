package com.shevchenko.Model.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "medium")
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;


    public Treatment(){
    }


    public int getId() {
        return id;
    }

    public void setDoctor(Doctor doctor) {this.doctor = doctor;}
    public Doctor getDoctor() {return doctor;}

    public void setPatient(Patient patient) {this.patient = patient;}
    public Patient getPatient() {return patient;}


    @Override
    public String toString() {
        return "models.Treatment{" +
                "id=" + id +
                "patient=" + patient.getName() +
                "doctor=" + doctor.getName() +
                '}';
    }
}
