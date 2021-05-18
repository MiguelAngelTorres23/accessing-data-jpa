package com.example.accessingdatajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * com.example.accessingdatajpa
 * Nombre_project: accessing-data-jpa
 * CustomerRepository
 * Created by: magua
 * Date : 18/05/2021
 * Description:
 **/

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    List<Alumno> findByNombre(String nombre);

    Alumno findById(long id);
}
