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

import pe.upc.onticket.Service.ServicioFamProducto;

import pe.upc.onticket.entity.FamProducto;



@RestController
@RequestMapping("/api")
public class RestFamProducto {
	
	@Autowired
	private ServicioFamProducto servicioFamProducto;
	
	
	//Registrar FamProducto
	@PostMapping("/famproducto")
	public FamProducto registrarFamProducto(@RequestBody FamProducto famproducto) {
		FamProducto fp;
		try {
			fp=servicioFamProducto.registrarFamProducto(famproducto);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return fp;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarFamProducto/{codigo}")
	public FamProducto actualizarFamProducto(@RequestBody FamProducto famproducto,@PathVariable(value = "codigo") Long codigo) {
		FamProducto fp;
		try {
			fp=servicioFamProducto.actualizarFamProducto(famproducto, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return fp;
	}
	
	//OBTENER DATOS FamProducto
	@GetMapping("/FamProductodata")
	public List<FamProducto> obtenerDatosFamProducto() {
		List<FamProducto> famproducto;
		try {
			famproducto=servicioFamProducto.obtenerDatosFamProducto();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return famproducto;
	}
	
	//ELIMINAR FAMPRODUCTO
	
	@DeleteMapping("/eliminarFamProducto/{codigo}")
	public FamProducto eliminarProducto(@PathVariable(value = "codigo") Long codigo) {
		FamProducto fp;
		try {
			fp=servicioFamProducto.eliminarFamProducto(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return fp;
	}
	
	//OBTENER BY ID
	@GetMapping("/buscarFamProducto/{codigo}")
	public FamProducto buscarFamProducto(@PathVariable(value="codigo")Long codigo) {
		FamProducto fp;
		
		try {
			fp=servicioFamProducto.obtenerFamProducto(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return fp;
	}

}
