package ar.edu.escmi.fi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.escmi.fi.model.Alumno;
import ar.edu.escmi.fi.repository.AlumnoRepository;
import ar.edu.escmi.fi.service.IAlumnoService;

@Service
public class IAlumnoServiceImp implements IAlumnoService{
  @Autowired
  AlumnoRepository alumnoRepository;

  @Override
  public void guardarAlumno(Alumno alumno) {
		alumno.setEstado(true);
		alumnoRepository.save(alumno);
  }

  @Override
  public void eliminarAlumno(Long id) throws Exception {
    Alumno auxiliar =new Alumno();
		auxiliar=buscarAlumno(id);
		auxiliar.setEstado(false);
		alumnoRepository.save(auxiliar);
  }

  @Override
  public void modificarAlumno(Alumno alumno) {
    alumnoRepository.save(alumno);
  }

  @Override
  public List<Alumno> listarAlumnos() {
    List<Alumno> auxiliar = new ArrayList<>();
		List<Alumno> auxiliar2 = new ArrayList<>();
		auxiliar=(List<Alumno>) alumnoRepository.findAll();	
		for (int i = 0; i < auxiliar.size(); i++) {
			if(auxiliar.get(i).getEstado().equals(true)){
				auxiliar2.add(auxiliar.get(i));
			}
		}
		return auxiliar2;
  }

  @Override
  public Alumno buscarAlumno(Long id) throws Exception {
    Alumno alumnoEncontrado = new Alumno();
		alumnoEncontrado=alumnoRepository.findById(id).orElseThrow(()->new Exception("alumno no encontrado"));
		return alumnoEncontrado;
  }
  
}
