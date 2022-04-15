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

import pe.upc.onticket.Service.ServicioMake;
import pe.upc.onticket.entity.Make;



@RestController
@RequestMapping("/api")
public class RestMake {
	
	@Autowired
	private ServicioMake servicioMake;
	
	
	//Registrar Make
	@PostMapping("/make")
	public Make registrarMake(@RequestBody Make make) {
		Make p;
		try {
			p=servicioMake.registrarMake(make);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return p;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarMake/{codigo}")
	public Make actualizarMake(@RequestBody Make make,@PathVariable(value = "codigo") Long codigo) {
		Make p;
		try {
			p=servicioMake.actualizarMake(make, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return p;
	}
	
	//OBTENER DATOS Make
	@GetMapping("/Makedata")
	public List<Make> obtenerDatosMake() {
		List<Make> make;
		try {
			make=servicioMake.obtenerDatosMake();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return make;
	}
	
	//ELIMINAR PRODUCTO
	
	@DeleteMapping("/eliminarMake/{codigo}")
	public Make eliminarMake(@PathVariable(value = "codigo") Long codigo) {
		Make mk;
		try {
			mk=servicioMake.eliminarMake(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return mk;
	}

}
