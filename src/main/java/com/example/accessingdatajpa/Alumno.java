package com.example.accessingdatajpa;

/**
 * com.example.accessingdatajpa
 * Nombre_project: accessing-data-jpa
 * Customer
 * Created by: magua
 * Date : 11/05/2021
 * Description:
 **/
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int edad;

    protected Alumno() {}

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return String.format(
                "Alumno[id=%d, nombre='%s', edad='%s']",
                id, nombre, edad);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}