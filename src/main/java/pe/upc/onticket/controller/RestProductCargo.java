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

import pe.upc.onticket.Service.ServicioProductCargo;

import pe.upc.onticket.entity.Cargo;
import pe.upc.onticket.entity.ProductCargo;



@RestController
@RequestMapping("/api")
public class RestProductCargo {
	
	@Autowired
	private ServicioProductCargo servicioProductCargo;
	
	
	//Registrar ProductCargo
	@PostMapping("/productcargo")
	public ProductCargo registrarProductCargo(@RequestBody ProductCargo productcargo) {
		ProductCargo pc;
		try {
			pc=servicioProductCargo.registrarProductCargo(productcargo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return pc;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarProductCargo/{codigo}")
	public ProductCargo actualizarProductCargo(@RequestBody ProductCargo productcargo,@PathVariable(value = "codigo") Long codigo) {
		ProductCargo p;
		try {
			p=servicioProductCargo.actualizarProductCargo(productcargo, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return p;
	}
	
	//OBTENER DATOS ProductCargo
	@GetMapping("/ProductCargodata")
	public List<ProductCargo> obtenerDatosProductCargo() {
		List<ProductCargo> productcargo;
		try {
			productcargo=servicioProductCargo.obtenerDatosProductCargo();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return productcargo;
	}
	
	//ELIMINAR PRODUCTO_CARGO
	
	@DeleteMapping("/eliminarProductCargo/{codigo}")
	public ProductCargo eliminarProductCargo(@PathVariable(value = "codigo") Long codigo) {
		ProductCargo pc;
		try {
			pc=servicioProductCargo.eliminarProductCargo(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return pc;
	}
	
	//OBTENER BY ID
	@GetMapping("/buscarProductCargo/{codigo}")
	public ProductCargo buscarProductCargo(@PathVariable(value="codigo")Long codigo) {
		ProductCargo pc;
		
		try {
			pc=servicioProductCargo.obtenerProductCargo(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return pc;
	}

	//LISTAR PRODUCT_CARGO BY CARGO ID
	@GetMapping("/buscarProductoCargoPorCargo/{codigo}")
	public List<ProductCargo> buscarProductCargoporCargo(@PathVariable(value="codigo")Long codigo) {
		List<ProductCargo> us;

		try {
			us=servicioProductCargo.obtenerProductCargoByCargoId(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}

		return us;
	}

}
