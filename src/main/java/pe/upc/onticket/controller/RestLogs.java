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

import pe.upc.onticket.Service.ServicioLogs;

import pe.upc.onticket.entity.Logs;



@RestController
@RequestMapping("/api")
public class RestLogs {
	
	@Autowired
	private ServicioLogs servicioLogs;
	
	
	//Registrar Logs
	@PostMapping("/logs")
	public Logs registrarLogs(@RequestBody Logs logs) {
		Logs lg;
		try {
			lg=servicioLogs.registrarLogs(logs);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return lg;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarLogs/{codigo}")
	public Logs actualizarLogs(@RequestBody Logs logs,@PathVariable(value = "codigo") Long codigo) {
		Logs p;
		try {
			p=servicioLogs.actualizarLogs(logs, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return p;
	}
	
	//OBTENER DATOS Logs
	@GetMapping("/Logsdata")
	public List<Logs> obtenerDatosLogs() {
		List<Logs> logs;
		try {
			logs=servicioLogs.obtenerDatosLogs();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return logs;
	}
	
	//ELIMINAR Logs
	
	@DeleteMapping("/eliminarLogs/{codigo}")
	public Logs eliminarLogs(@PathVariable(value = "codigo") Long codigo) {
		Logs lg;
		try {
			lg=servicioLogs.eliminarLogs(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return lg;
	}
	
	//OBTENER BY ID
	@GetMapping("/buscarLogs/{codigo}")
	public Logs buscarLogs(@PathVariable(value="codigo")Long codigo) {
		Logs lg;
		
		try {
			lg=servicioLogs.obtenerLogs(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		
		return lg;
	}


}
