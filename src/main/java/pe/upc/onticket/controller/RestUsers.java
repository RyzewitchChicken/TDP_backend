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


import pe.upc.onticket.Service.ServicioUsers;

import pe.upc.onticket.entity.Users;


@RestController
@RequestMapping("/api")
public class RestUsers {

	/*
	 ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⠿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿ 
	 ⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⣉⡥⠶⢶⣿⣿⣿⣿⣷⣆⠉⠛⠿⣿⣿⣿⣿⣿⣿⣿ 
	 ⣿⣿⣿⣿⣿⣿⣿⡿⢡⡞⠁⠀⠀⠤⠈⠿⠿⠿⠿⣿⠀⢻⣦⡈⠻⣿⣿⣿⣿⣿ 
	 ⣿⣿⣿⣿⣿⣿⣿⡇⠘⡁⠀⢀⣀⣀⣀⣈⣁⣐⡒⠢⢤⡈⠛⢿⡄⠻⣿⣿⣿⣿ 
	 ⣿⣿⣿⣿⣿⣿⣿⡇⠀⢀⣼⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⠉⠐⠄⡈⢀⣿⣿⣿⣿ 
	 ⣿⣿⣿⣿⣿⣿⣿⠇⢠⣿⣿⣿⣿⡿⢿⣿⣿⣿⠁⢈⣿⡄⠀⢀⣀⠸⣿⣿⣿⣿ 
	 ⣿⣿⣿⣿⡿⠟⣡⣶⣶⣬⣭⣥⣴⠀⣾⣿⣿⣿⣶⣾⣿⣧⠀⣼⣿⣷⣌⡻⢿⣿ 
	 ⣿⣿⠟⣋⣴⣾⣿⣿⣿⣿⣿⣿⣿⡇⢿⣿⣿⣿⣿⣿⣿⡿⢸⣿⣿⣿⣿⣷⠄⢻ 
	 ⡏⠰⢾⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⢂⣭⣿⣿⣿⣿⣿⠇⠘⠛⠛⢉⣉⣠⣴⣾ 
	 ⣿⣷⣦⣬⣍⣉⣉⣛⣛⣉⠉⣤⣶⣾⣿⣿⣿⣿⣿⣿⡿⢰⣿⣿⣿⣿⣿⣿⣿⣿ 
	 ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡘⣿⣿⣿⣿⣿⣿⣿⣿⡇⣼⣿⣿⣿⣿⣿⣿⣿⣿ 
	 ⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⢸⣿⣿⣿⣿⣿⣿⣿⠁⣿⣿⣿⣿⣿⣿⣿⣿⣿
	  */
	@Autowired
	private ServicioUsers servicioUsers;
	
	
	//Registrar Users
	@PostMapping("/users")
	public Users registrarUsers(@RequestBody Users users) {
		Users p;
		try {
			p=servicioUsers.registrarUsers(users);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return p;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarUsers/{codigo}")
	public Users actualizarUsers(@RequestBody Users users,@PathVariable(value = "codigo") Long codigo) {
		Users p;
		try {
			p=servicioUsers.actualizarUsers(users, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return p;
	}
	
	//OBTENER DATOS Users
	@GetMapping("/Usersdata")
	public List<Users> obtenerDatosUsers() {
		List<Users> users;
		try {
			users=servicioUsers.obtenerDatosUsers();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return users;
	}
	
	//ELIMINAR PRODUCTO
	
	@DeleteMapping("/eliminarUsers/{codigo}")
	public Users eliminarUsers(@PathVariable(value = "codigo") Long codigo) {
		Users us;
		try {
			us=servicioUsers.eliminarUsers(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return us;
	}
	
	
	//OBTENER BY ID
	@GetMapping("/buscarUsers/{codigo}")
	public Users buscarUsers(@PathVariable(value="codigo")Long codigo) {
		Users us;
		
		try {
			us=servicioUsers.obtenerUsers(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return us;
	}
	

	
	//LISTAR ROLES
	@GetMapping("/buscarRoles/{codigo}")
	public List<Object[]> buscarRoles(@PathVariable(value="codigo")Long codigo) {
		List<Object[]> us;
		
		try {
			us=servicioUsers.obtenerRoles(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return us;
	}
	
	
	//LISTAR PERSON
	@GetMapping("/buscarPerson/{codigo}")
	public List<Object[]> buscarPerson(@PathVariable(value="codigo")Long codigo) {
		List<Object[]> us;
		
		try {
			us=servicioUsers.obtenerPerson(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return us;
	}
}
