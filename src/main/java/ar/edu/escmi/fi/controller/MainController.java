package ar.edu.escmi.fi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.escmi.fi.model.Alumno;
import ar.edu.escmi.fi.service.IAlumnoService;

@Controller
public class MainController {
  @Autowired
  IAlumnoService alumnoService;

  @GetMapping({"/index","/home","/"})
  public String getmenu(){
    return "formulario";
  }
  @GetMapping("/listado")
  public ModelAndView getlista(){
    ModelAndView vista = new ModelAndView("listado");
    vista.addObject("listaUsuario", alumnoService.listarAlumnos());
    return vista;
  }
  @GetMapping("/editarAlumno/{dni}")
  public ModelAndView editalumno(@PathVariable(name="dni") Long dni) throws Exception{
    Alumno alumnoencontrado = new Alumno();
    alumnoencontrado=alumnoService.buscarAlumno(dni);    
    ModelAndView encontrado = new ModelAndView("formulario");
    encontrado.addObject("alumno", alumnoencontrado);
    encontrado.addObject("editMode",true);
    return encontrado;
  }
  @PostMapping("/modificarAlumno")
  public ModelAndView modUser(@ModelAttribute("alumno") Alumno alum){
    alumnoService.modificarAlumno(alum);
    ModelAndView vista = new ModelAndView("listado");
    vista.addObject("listaAlumno", alumnoService.listarAlumnos());
    return vista;
  }
  @GetMapping("/eliminarAlumno/{id}")
	public String eliminar(@PathVariable Long id, Model model) {	
		try {
		alumnoService.eliminarAlumno(id);
		}catch(Exception e) {
			model.addAttribute("formUsuarioErrorMessage", e.getMessage());
			return "redirect:/formulario";			
		}
		return "redirect:/listado";
	}
  @PostMapping("/formulario")
  public String saveUser(@Valid @ModelAttribute("alumno") Alumno alum, BindingResult resultado, Model model){
    if (resultado.hasErrors()) {
      model.addAttribute("alumno", alum);
      return "formulario";
    }
    try {
      alumnoService.guardarAlumno(alum);
    } catch (Exception e) {
			model.addAttribute("unAlumno", alum);
			return "formulario";	
    }
		model.addAttribute("unUsuario", alum);			
		return "listado";
  }
}
