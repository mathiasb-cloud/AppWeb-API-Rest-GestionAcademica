package cibertec.pe.service;
import java.util.List;
import java.util.Optional;

import cibertec.pe.entity.Cuenta;
import cibertec.pe.model.Alumno;

public interface IAlumnoService {
	
	public List<Alumno> listarAlumnos();
	public Alumno crearAlumno(Alumno alumno);
	public Optional<Alumno> buscarAlumno(int codigo);
	public String editarAlumno(int codigo, Alumno alumno);
	public void eliminarAlumno(int codigo);
	
	
	public Cuenta crearAlumnoConCuenta(Alumno alumno, Cuenta cuenta);
	
	
}