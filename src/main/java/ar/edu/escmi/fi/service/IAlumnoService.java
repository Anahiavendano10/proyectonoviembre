package ar.edu.escmi.fi.service;

import java.util.List;

import ar.edu.escmi.fi.model.Alumno;

public interface IAlumnoService {
  public void guardarAlumno( Alumno alumno);
	public void eliminarAlumno(Long id) throws Exception;
	public void modificarAlumno(Alumno alumno);
	public List<Alumno> listarAlumnos(); 
	public Alumno buscarAlumno(Long id) throws Exception;
}
