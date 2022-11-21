package ar.edu.escmi.fi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Alumno {
  @Id
  @NotEmpty
  @Min(value=1000000,message = "El DNI debe ser mayor al millon")
  @Max(value = 999999999, message = "El DNI debe ser menor a 999999999")
  private Long dni;
  @NotEmpty
  @Max(value = 999999999, message = "La libreta Universitaria debe ser menor a 999999999")
  private Long libretaUniversitaria;
  @Size(min=3, max=100, message="EL apellido del alumno debe tener 3 caracteres minimo, maximo 100")
  @NotEmpty(message="El apellido del alumno no puede estar vacio")
  @Column(name = "apeliido")
  private String apellido;
  @Size(min=3, max=100, message="EL nombre del alumno debe tener 3 caracteres minimo, maximo 100")
  @NotEmpty(message="El nombre del alumno no puede estar vacio")
  @Column(name = "nombre")
  private String nombre;
  @Size(min=3, max=100, message="EL domicilio del alumno debe tener 3 caracteres minimo, maximo 100")
  @NotEmpty(message="El domicilio del alumno no puede estar vacio")
  @Column(name = "domicilio")
  private String domicilio;
  private Boolean estado;

  public Alumno(
      @NotEmpty @Min(value = 1000000, message = "El DNI debe ser mayor al millon") @Max(value = 999999999, message = "El DNI debe ser menor a 999999999") Long dni,
      @NotEmpty @Max(value = 999999999, message = "La libreta Universitaria debe ser menor a 999999999") Long libretaUniversitaria,
      @Size(min = 3, max = 100, message = "EL apellido del alumno debe tener 3 caracteres minimo, maximo 100") @NotEmpty(message = "El apellido del alumno no puede estar vacio") String apellido,
      @Size(min = 3, max = 100, message = "EL nombre del alumno debe tener 3 caracteres minimo, maximo 100") @NotEmpty(message = "El nombre del alumno no puede estar vacio") String nombre,
      @Size(min = 3, max = 100, message = "EL domicilio del alumno debe tener 3 caracteres minimo, maximo 100") @NotEmpty(message = "El domicilio del alumno no puede estar vacio") String domicilio,
      Boolean estado) {
    this.dni = dni;
    this.libretaUniversitaria = libretaUniversitaria;
    this.apellido = apellido;
    this.nombre = nombre;
    this.domicilio = domicilio;
    this.estado = estado;
  }

  public Alumno() {
  }

  public Long getDni() {
    return dni;
  }

  public void setDni(Long dni) {
    this.dni = dni;
  }

  public Long getLibretaUniversitaria() {
    return libretaUniversitaria;
  }

  public void setLibretaUniversitaria(Long libretaUniversitaria) {
    this.libretaUniversitaria = libretaUniversitaria;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDomicilio() {
    return domicilio;
  }

  public void setDomicilio(String domicilio) {
    this.domicilio = domicilio;
  }
  public Boolean getEstado() {
    return estado;
  }

  public void setEstado(Boolean estado) {
    this.estado = estado;
  }
}
