package pe.upc.onticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import pe.upc.onticket.Service.ServicioFuncion;
import pe.upc.onticket.entity.Funcion;



@RestController
@RequestMapping("/api")
public class RestFuncion {
	@Autowired
	private ServicioFuncion servicioFuncion;
	
	
	//Registrar Funcion
	@PostMapping("/funcion")
	public Funcion registrarFuncion(@RequestBody Funcion funcion) {
		Funcion f;
		try {
			f=servicioFuncion.registrarFuncion(funcion);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return f;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarFuncion/{codigo}")
	public Funcion actualizarFuncion(@RequestBody Funcion funcion,@PathVariable(value = "codigo") Long codigo) {
		Funcion f;
		try {
			f=servicioFuncion.actualizarFuncion(funcion, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return f;
	}
	
	//OBTENER DATOS Funcion
	@GetMapping("/Funciondata")
	public List<Funcion> obtenerDatosFuncion() {
		List<Funcion> funcion;
		try {
			funcion=servicioFuncion.obtenerDatosFuncion();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return funcion;
	}
	
	
	//ELIMINAR FUNCION
	
	@DeleteMapping("/eliminarFuncion/{codigo}")
	public Funcion eliminarProducto(@PathVariable(value = "codigo") Long codigo) {
		Funcion f;
		try {
			f=servicioFuncion.eliminarFuncion(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return f;
	}

}
