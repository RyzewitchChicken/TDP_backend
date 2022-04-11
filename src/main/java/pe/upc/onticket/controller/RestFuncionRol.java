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

import pe.upc.onticket.Service.ServicioFuncionRol;

import pe.upc.onticket.entity.FuncionRol;



@RestController
@RequestMapping("/api")
public class RestFuncionRol {
	@Autowired
	private ServicioFuncionRol servicioFuncionRol;
	
	
	//Registrar FuncionRol
	@PostMapping("/funcionrol")
	public FuncionRol registrarFuncionRol(@RequestBody FuncionRol funcionrol) {
		FuncionRol fr;
		try {
			fr=servicioFuncionRol.registrarFuncionRol(funcionrol);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return fr;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarFuncionRol/{codigo}")
	public FuncionRol actualizarFuncionRol(@RequestBody FuncionRol funcionrol,@PathVariable(value = "codigo") Long codigo) {
		FuncionRol fr;
		try {
			fr=servicioFuncionRol.actualizarFuncionRol(funcionrol, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return fr;
	}
	
	//OBTENER DATOS FuncionRol
	@GetMapping("/FuncionRoldata")
	public List<FuncionRol> obtenerDatosFuncionRol() {
		List<FuncionRol> funcionrol;
		try {
			funcionrol=servicioFuncionRol.obtenerDatosFuncionRol();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return funcionrol;
	}
	
	//ELIMINAR FUNCROL
	
	@DeleteMapping("/eliminarFuncionRol/{codigo}")
	public FuncionRol eliminarProducto(@PathVariable(value = "codigo") Long codigo) {
		FuncionRol fr;
		try {
			fr=servicioFuncionRol.eliminarFuncionRol(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return fr;
	}

}
