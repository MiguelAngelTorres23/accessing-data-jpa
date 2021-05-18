package com.example.accessingdatajpa;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Optional;

/**
 * com.example.accessingdatajpa
 * Nombre_project: accessing-data-jpa
 * JsonController
 * Created by: magua
 * Date : 18/05/2021
 * Description:
 **/

@RestController
public class JsonController {

    private final AlumnoService alumnoService;
    private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

    @Autowired
    public JsonController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/processJson")
    public ModelAndView getJson(Model model) {
        return new ModelAndView("alumno", "Alumno", new Alumno());
    }
    @PostMapping("/processJson")
    public String getSubmit(@RequestBody String json) throws IOException {

        Alumno alumnoEntity;
        try{
            String result = java.net.URLDecoder.decode(json, StandardCharsets.UTF_8.name());
            ObjectMapper om = new ObjectMapper();
            result = result.substring(5);
            alumnoEntity = om.readValue(result, Alumno.class);
            alumnoService.addAlumno(alumnoEntity);
            System.out.println(alumnoEntity);

        }catch (Exception e){
            e.printStackTrace();
        }


        return "Correcto!";
    }

    @GetMapping("find/{id}")
    public String findAlumnoById (@PathVariable("id") long id){
        Optional<Alumno> alumno = alumnoService.findAlumnoById(id);
        String texto = alumno.toString().substring(8);
        return texto;
    }
    @GetMapping("findAll")
    private ResponseEntity<List<Alumno>> findAllAlumnos() {
        List<Alumno> alumnos = alumnoService.findAllAlumnos();
        return new ResponseEntity<>(alumnos, HttpStatus.OK);
    }

}