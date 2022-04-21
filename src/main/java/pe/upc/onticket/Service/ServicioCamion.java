package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.upc.onticket.entity.Camion;
import pe.upc.onticket.repositorio.RepositorioCamion;




@Service
public class ServicioCamion {
	
	@Autowired RepositorioCamion repositorioCamion;
	
	
	/*registrar Camion*/
	@Transactional(rollbackFor= Exception.class)
	public Camion registrarCamion(Camion camion) throws Exception {
		if(camion.getCodigo()==null) {
			return repositorioCamion.save(camion);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public Camion actualizarCamion(Camion camion, Long codigo) throws Exception {
		Camion cam=repositorioCamion.getCamion(codigo);
		if(camion.getTruckPlate()!=null) {
			cam.setTruckPlate(camion.getTruckPlate());
		}
		if(camion.getModel()!=null) {
			cam.setModel(camion.getModel());
		}
		if(camion.getMake()!=null) {
			cam.setMake(camion.getMake());
		}
		if(camion.getDevices()!=null) {
			cam.setDevices(camion.getDevices());
		}
		return repositorioCamion.save(cam);
		
	}
	
	//Obtener Datos
	public List<Camion> obtenerDatosCamion() {
		List<Camion> camion;
		camion=repositorioCamion.findAll();
		return camion;
	}
	
	//OBTENER CAMION BY ID
	public Camion obtenerCamion(Long codigo) throws Exception {
		Camion c;
		c=repositorioCamion.getCamion(codigo);
		if(c==null)throw new Exception("camion no encontrado");
		return c;
	}
	
	
	//ELIMINAR UN CAMIOn
	public Camion eliminarCamion(Long codigo) throws Exception {
		Camion c;
		c=repositorioCamion.getCamion(codigo);
		if(c.getCodigo()!=null) {
			repositorioCamion.delete(c);
		}else {
			throw new Exception();
		}
		return c;
	}
	
	


}
