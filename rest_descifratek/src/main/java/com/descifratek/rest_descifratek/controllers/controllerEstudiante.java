package com.descifratek.rest_descifratek.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.descifratek.rest_descifratek.models.Estudiante;
import com.descifratek.rest_descifratek.repositories.RepositoryEstudiante;
import com.google.gson.Gson;

@RestController
public class controllerEstudiante {
	
	public controllerEstudiante() {
		
	}
	
	private HashMap<Integer, Estudiante> EstudianteMap = new HashMap<>();
	
	@Autowired
	private RepositoryEstudiante repositoryEstudiante;
	
	@PostMapping(path="/Estudiante", consumes="application/json", produces="application/json")
	public String CrearEstudiante(@RequestBody String json) {
		Gson gson = new Gson();
		Estudiante estudiante = gson.fromJson(json, Estudiante.class);
		EstudianteMap.put(estudiante.getIdEstudiante(), estudiante);
		Estudiante estudianteSave = repositoryEstudiante.save(estudiante);
		return gson.toJson(estudianteSave);
	}
	
	@GetMapping(path="/Estudiante", produces="application/json")
	public String ObtenerEstudiantes(@RequestParam(value="idEstudiante", required=false) Integer idEstudiante) {
		Gson gson = new Gson();
		
		if (idEstudiante == null) {	
			List<Estudiante> EstudianteLista = repositoryEstudiante.findAll();
			EstudianteMap.clear();
			for (Estudiante estudiante : EstudianteLista) {
				EstudianteMap.put(estudiante.getIdEstudiante(), estudiante);
			}
			return gson.toJson(EstudianteMap.values());
		} else {
			List<Estudiante> estudiantePorId = repositoryEstudiante.findByIdEstudiante(idEstudiante);
			
			return gson.toJson(estudiantePorId);
		}
	}
	
	@DeleteMapping(path="/Estudiante/{id_estudiante}", produces="application/json")
	public String EliminarEstudiantes(@PathVariable("id_estudiante") Integer idEstudiante) {
		Gson gson = new Gson();
		Estudiante estudianteEliminar = new Estudiante();
		
		List<Estudiante> estudiantePorId = repositoryEstudiante.findByIdEstudiante(idEstudiante);
		for (Estudiante estudiante : estudiantePorId) {
			repositoryEstudiante.delete(estudiante);
			estudianteEliminar = estudiante;
		}
		String json =gson.toJson(estudianteEliminar);
		System.out.println(json);
		return gson.toJson(estudianteEliminar);
	}
}
