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

import pe.upc.onticket.Service.ServicioProducto;

import pe.upc.onticket.entity.Producto;



@RestController
@RequestMapping("/api")
public class RestProducto {
	
	@Autowired
	private ServicioProducto servicioProducto;
	
	
	//Registrar Producto
	@PostMapping("/producto")
	public Producto registrarProducto(@RequestBody Producto producto) {
		Producto p;
		try {
			p=servicioProducto.registrarProducto(producto);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return p;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarProducto/{codigo}")
	public Producto actualizarProducto(@RequestBody Producto producto,@PathVariable(value = "codigo") Long codigo) {
		Producto p;
		try {
			p=servicioProducto.actualizarProducto(producto, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return p;
	}
	
	//OBTENER DATOS Producto
	@GetMapping("/Productodata")
	public List<Producto> obtenerDatosProducto() {
		List<Producto> producto;
		try {
			producto=servicioProducto.obtenerDatosProducto();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return producto;
	}
	
	//ELIMINAR PRODUCTO
	
	@DeleteMapping("/eliminarProducto/{codigo}")
	public Producto eliminarProducto(@PathVariable(value = "codigo") Long codigo) {
		Producto pr;
		try {
			pr=servicioProducto.eliminarProducto(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return pr;
	}
	
	//OBTENER BY ID
	@GetMapping("/buscarProducto/{codigo}")
	public Producto buscarProducto(@PathVariable(value="codigo")Long codigo) {
		Producto pr;
		
		try {
			pr=servicioProducto.obtenerProducto(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return pr;
	}

}
