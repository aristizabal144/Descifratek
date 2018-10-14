package com.descifratek.rest_descifratek.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.descifratek.rest_descifratek.models.Estudiante;

@Repository
public interface RepositoryEstudiante extends JpaRepository<Estudiante, Integer> {

	List<Estudiante> findByIdEstudiante(@Param("idEstudiante") Integer idEstudiante);
}
