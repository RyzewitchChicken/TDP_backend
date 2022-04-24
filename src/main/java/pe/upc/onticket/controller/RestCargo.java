package pe.upc.onticket.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import pe.upc.onticket.Service.ServicioCargo;
import pe.upc.onticket.entity.Camion;
import pe.upc.onticket.entity.Cargo;


@RestController
@RequestMapping("/api")
public class RestCargo {
	
	@Autowired
	private ServicioCargo servicioCargo;
	
	
	//Registrar cargo
	@PostMapping("/cargo")
	public Cargo registrarCargo(@RequestBody Cargo cargo) {
		Cargo cr;
		try {
			cr=servicioCargo.registrarCargo(cargo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return cr;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarCargo/{codigo}")
	public Cargo actualizarCargo(@RequestBody Cargo cargo,@PathVariable(value = "codigo") Long codigo) {
		Cargo p;
		try {
			p=servicioCargo.actualizarCargo(cargo, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return p;
	}
	
	//OBTENER DATOS cargo
	@GetMapping("/Cargodata")
	public List<Cargo> obtenerDatosCargo() {
		List<Cargo> cargo;
		try {
			cargo=servicioCargo.obtenerDatosCargo();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return cargo;
	}
	
	//ELIMINAR Cargo
	
	@DeleteMapping("/eliminarCargo/{codigo}")
	public Cargo eliminarCargo(@PathVariable(value = "codigo") Long codigo) {
		Cargo cr;
		try {
			cr=servicioCargo.eliminarCargo(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return cr;
	}
	
	//OBTENER BY ID
	@GetMapping("/buscarCargo/{codigo}")
	public Cargo buscarCargo(@PathVariable(value="codigo")Long codigo) {
		Cargo cr;
		
		try {
			cr=servicioCargo.obtenerCargo(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return cr;
	}
	/*
	@PostMapping("/cargo/upload")
	public ResponseEntity<?> upload(@RequestParam("codigo") Long archivo, @RequestParam("codigo") Long codigo){
		Map<String, Object> response=new HashMap<>();
		Cargo cargo;
		try {
			cargo=servicioCargo.obtenerCargo(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontraron cargos");
		}


			
			cargo.setPersonClientId(archivo);
			
			try {
				servicioCargo.actualizarCargo(cargo, codigo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar cargo");
				
			}
			
			response.put("cargo", cargo);
			response.put("mensaje", "Se subio correctamente el archivo");
		
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}*/

}
