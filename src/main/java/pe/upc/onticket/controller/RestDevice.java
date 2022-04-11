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

import pe.upc.onticket.Service.ServicioDevices;
import pe.upc.onticket.entity.Devices;





@RestController
@RequestMapping("/api")
public class RestDevice {
	
	@Autowired
	private ServicioDevices servicioDevices;
	
	
	//Registrar Devices
	@PostMapping("/devices")
	public Devices registrarDevices(@RequestBody Devices devices) {
		Devices d;
		try {
			d=servicioDevices.registrarDevices(devices);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return d;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarDevices/{codigo}")
	public Devices actualizarDevices(@RequestBody Devices devices,@PathVariable(value = "codigo") Long codigo) {
		Devices d;
		try {
			d=servicioDevices.actualizarDevices(devices, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return d;
	}
	
	//OBTENER DATOS Devices
	@GetMapping("/Devicesdata")
	public List<Devices> obtenerDatosDevices() {
		List<Devices> devices;
		try {
			devices=servicioDevices.obtenerDatosDevices();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return devices;
	}
	
	//ELIMINAR DEVICE
	
	@DeleteMapping("/eliminarDevice/{codigo}")
	public Devices eliminarProducto(@PathVariable(value = "codigo") Long codigo) {
		Devices d;
		try {
			d=servicioDevices.eliminarDevices(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return d;
	}

}
