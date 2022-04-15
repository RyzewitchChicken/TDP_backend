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

import pe.upc.onticket.Service.ServicioModel;
import pe.upc.onticket.entity.Model;


@RestController
@RequestMapping("/api")
public class RestModel {
	
	@Autowired
	private ServicioModel servicioModel;
	
	
	//Registrar Model
	@PostMapping("/model")
	public Model registrarModel(@RequestBody Model model) {
		Model p;
		try {
			p=servicioModel.registrarModel(model);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return p;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarModel/{codigo}")
	public Model actualizarModel(@RequestBody Model model,@PathVariable(value = "codigo") Long codigo) {
		Model p;
		try {
			p=servicioModel.actualizarModel(model, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return p;
	}
	
	//OBTENER DATOS Model
	@GetMapping("/Modeldata")
	public List<Model> obtenerDatosModel() {
		List<Model> model;
		try {
			model=servicioModel.obtenerDatosModel();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return model;
	}
	
	//ELIMINAR PRODUCTO
	
	@DeleteMapping("/eliminarModel/{codigo}")
	public Model eliminarModel(@PathVariable(value = "codigo") Long codigo) {
		Model md;
		try {
			md=servicioModel.eliminarModel(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return md;
	}

}
