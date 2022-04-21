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

import pe.upc.onticket.Service.ServicioUser;

import pe.upc.onticket.entity.User;





@RestController
@RequestMapping("/api")
public class RestUser {
	
	@Autowired
	private ServicioUser servicioUser;
	
	
	//Registrar User
	@PostMapping("/user")
	public User registrarUser(@RequestBody User user) {
		User u;
		try {
			u=servicioUser.registrarUser(user);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return u;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarUser/{codigo}")
	public User actualizarUser(@RequestBody User user,@PathVariable(value = "codigo") Long codigo) {
		User u;
		try {
			u=servicioUser.actualizarUser(user, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return u;
	}
	
	//OBTENER DATOS User
	@GetMapping("/Userdata")
	public List<User> obtenerDatosUser() {
		List<User> user;
		try {
			user=servicioUser.obtenerDatosUser();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return user;
	}
	
	//ELIMINAR USER
	
	@DeleteMapping("/eliminarUser/{codigo}")
	public User eliminarProducto(@PathVariable(value = "codigo") Long codigo) {
		User us;
		try {
			us=servicioUser.eliminarUser(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return us;
	}
	
	//OBTENER BY ID
	@GetMapping("/buscarUser/{codigo}")
	public User buscarUser(@PathVariable(value="codigo")Long codigo) {
		User us;
		
		try {
			us=servicioUser.obtenerUser(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return us;
	}


}
