package com.descifratek.rest_descifratek.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estudiante {
	
	@Id
	@Column(name="idEstudiante")
	private Integer idEstudiante;
	@Column(name="nombre")
	private String nombre;
	@Column(name="apellido")
	private String apellido;
	@Column(name="correo")
	private String correo;
	@Column(name="carrera")
	private String carrera;
	@Column(name="idHuella")
	private Integer idHuella;
	@Column(name="foto")
	private String foto;
	
	public Estudiante() {
		
	}
	
	public Estudiante(Integer idEstudiante, String nombre, String apellido, String correo, String carrera, Integer idHuella, String foto) {
		
		this.idEstudiante = idEstudiante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.carrera = carrera;
		this.idHuella = idHuella;
		this.foto = foto;
	}

	public Integer getIdEstudiante() {
		return idEstudiante;
	}

	public void setIdEstudiante(Integer idEstudiante) {
		this.idEstudiante = idEstudiante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	public Integer getIdHuella() {
		return idHuella;
	}

	public void setIdHuella(Integer idHuella) {
		this.idHuella = idHuella;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
}
