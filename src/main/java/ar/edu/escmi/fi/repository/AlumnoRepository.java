package ar.edu.escmi.fi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.edu.escmi.fi.model.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno,Long>{
  
}
