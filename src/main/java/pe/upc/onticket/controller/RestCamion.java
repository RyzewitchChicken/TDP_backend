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

import pe.upc.onticket.Service.ServicioCamion;
import pe.upc.onticket.entity.Camion;

//Yo se que esto se subira al github, si alguien además de yo lee esto, sepa que me 
//demore 4 dias en tratar de que el rest funcione, si es que no funciono habra otra linea mas D:
@RestController
@RequestMapping("/api")
public class RestCamion {
	@Autowired
	private ServicioCamion servicioCamion;
	
	
	//Registrar Camion
	@PostMapping("/camion")
	public Camion registrarCamion(@RequestBody Camion camion) {
		Camion c;
		try {
			c=servicioCamion.registrarCamion(camion);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se puede registrar");
		}
		return c;
	}
	//ACTUALIZAR DATOS 
	
	@PostMapping("/actualizarCamion/{codigo}")
	public Camion actualizarCamion(@RequestBody Camion camion,@PathVariable(value = "codigo") Long codigo) {
		Camion c;
		try {
			c=servicioCamion.actualizarCamion(camion, codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar");
		}
		return c;
	}
	
	//OBTENER DATOS Camion
	@GetMapping("/Camiondata")
	public List<Camion> obtenerDatosCamion() {
		List<Camion> camion;
		try {
			camion=servicioCamion.obtenerDatosCamion();
		} catch (Exception e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
		}
		return camion;
	}
	
	@PostMapping("/camion/uploadC")
	public ResponseEntity<?> uploadCreate(@RequestParam("archivo") MultipartFile archivo, @RequestParam("camion") Camion camion){
		Map<String, Object> response=new HashMap<>();
		
		if(!archivo.isEmpty()) {
			String nombreArch=UUID.randomUUID().toString()+"_"+ archivo.getOriginalFilename().replace(" ", "");
			Path ruta=Paths.get("uploads").resolve(nombreArch).toAbsolutePath();
			try {
				Files.copy(archivo.getInputStream(), ruta);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen"+nombreArch);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			//Borrar imagen anterior si existe
			String nomAnterior=camion.getTruckImage();
			
			if(nomAnterior != null && nomAnterior.length() > 0) {
				Path rutaImgAnt = Paths.get("uploads").resolve(nomAnterior).toAbsolutePath();
				File archImgAnt = rutaImgAnt.toFile();
				if (archImgAnt.exists() && archImgAnt.canRead()) {
					archImgAnt.delete();
				}
			}
			
			camion.setTruckImage(nombreArch);
			
			
			response.put("camion", camion);
			response.put("mensaje", "Se subio correctamente el archivo");
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	@PostMapping("/camion/upload")
	public ResponseEntity<?> upload(@RequestParam("archivo") MultipartFile archivo, @RequestParam("codigo") Long codigo){
		Map<String, Object> response=new HashMap<>();
		Camion camion;
		try {
			camion=servicioCamion.obtenerCamion(codigo);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontraron Productos");
		}
		if(!archivo.isEmpty()) {
			String nombreArch=UUID.randomUUID().toString()+"_"+ archivo.getOriginalFilename().replace(" ", "");
			Path ruta=Paths.get("uploads").resolve(nombreArch).toAbsolutePath();
			try {
				Files.copy(archivo.getInputStream(), ruta);
			} catch (IOException e) {
				response.put("mensaje", "Error al subir la imagen"+nombreArch);
				response.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			//Borrar imagen anterior si existe
			String nomAnterior=camion.getTruckImage();
			
			if(nomAnterior != null && nomAnterior.length() > 0) {
				Path rutaImgAnt = Paths.get("uploads").resolve(nomAnterior).toAbsolutePath();
				File archImgAnt = rutaImgAnt.toFile();
				if (archImgAnt.exists() && archImgAnt.canRead()) {
					archImgAnt.delete();
				}
			}
			
			camion.setTruckImage(nombreArch);
			
			try {
				servicioCamion.actualizarCamion(camion, codigo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede registrar producto");
				
			}
			
			response.put("camion", camion);
			response.put("mensaje", "Se subio correctamente el archivo");
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	//ELIMINAR CAMION
	
	@DeleteMapping("/eliminarCamion/{codigo}")
	public Camion eliminarProducto(@PathVariable(value = "codigo") Long codigo) {
		Camion c;
		try {
			Camion camion = servicioCamion.obtenerCamion(codigo);
			String nomAnterior=camion.getTruckImage();
			
			if(nomAnterior != null && nomAnterior.length() > 0) {
				Path rutaImgAnt = Paths.get("uploads").resolve(nomAnterior).toAbsolutePath();
				File archImgAnt = rutaImgAnt.toFile();
				if (archImgAnt.exists() && archImgAnt.canRead()) {
					archImgAnt.delete();
				}
			}
			
			c=servicioCamion.eliminarCamion(codigo);
		}catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no se puede borrar");
		}
		return c;
	}

}
