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

import pe.upc.onticket.Service.ServicioRol;

import pe.upc.onticket.entity.Rol;



@RestController
@RequestMapping("/api")
public class RestRol {
	@Autowired
	private ServicioRol servicioRol;
	
	
	//Registrar Rol
	@PostMapping("/rol")
	public Rol registrarRol(@RequestBody Rol rol) {
		Rol r;
		try {
			r=servicioRol.registrarRol(rol);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return r;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarRol/{codigo}")
	public Rol actualizarRol(@RequestBody Rol rol,@PathVariable(value = "codigo") Long codigo) {
		Rol r;
		try {
			r=servicioRol.actualizarRol(rol, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede actualizar");
		}
		return r;
	}
	
	//OBTENER DATOS Rol
	@GetMapping("/Roldata")
	public List<Rol> obtenerDatosRol() {
		List<Rol> rol;
		try {
			rol=servicioRol.obtenerDatosRol();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return rol;
	}
	
	
	//ELIMINAR ROL
	
	@DeleteMapping("/eliminarRol/{codigo}")
	public Rol eliminarProducto(@PathVariable(value = "codigo") Long codigo) {
		Rol c;
		try {
			c=servicioRol.eliminarRol(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return c;
	}
	
	
	//OBTENER BY ID
	@GetMapping("/buscarRol/{codigo}")
	public Rol buscarRol(@PathVariable(value="codigo")Long codigo) {
		Rol r;
		
		try {
			r=servicioRol.obtenerRol(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return r;
	}



}
