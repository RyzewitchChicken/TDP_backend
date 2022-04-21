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

import pe.upc.onticket.Service.ServicioCargo;
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

}
