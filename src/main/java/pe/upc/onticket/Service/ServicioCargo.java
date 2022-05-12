package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.upc.onticket.entity.Cargo;
import pe.upc.onticket.entity.Users;
import pe.upc.onticket.repositorio.RepositorioCargo;


@Service
public class ServicioCargo {
	
	@Autowired RepositorioCargo repositorioCargo;
	
	
	/*registrar Cargo*/
	@Transactional(rollbackFor= Exception.class)
	public Cargo registrarCargo(Cargo cargo) throws Exception {
		if(cargo.getCodigo()==null) {
			return repositorioCargo.save(cargo);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public Cargo actualizarCargo(Cargo cargo, Long codigo) throws Exception {
		Cargo cr=repositorioCargo.getCargo(codigo);
		if(cargo.getCargoName()!=null) {
			cr.setCargoName(cargo.getCargoName());
		}
		if(cargo.getCargoDate()!=null) {
			cr.setCargoDate(cargo.getCargoDate());
		}
		if(cargo.getCargoHour()!=null) {
			cr.setCargoHour(cargo.getCargoHour());
		}
		if(cargo.getCargoInitialUbication()!=null) {
			cr.setCargoInitialUbication(cargo.getCargoInitialUbication());
		}
		if(cargo.getCargoFinalUbication()!=null) {
			cr.setCargoFinalUbication(cargo.getCargoFinalUbication());
		}
		if(cargo.getCargoStatus()!=null) {
			cr.setCargoStatus(cargo.getCargoStatus());
		}
		if(cargo.getCargoRouteDuration()!=null) {
			cr.setCargoRouteDuration(cargo.getCargoRouteDuration());
		}
		if(cargo.getCargoRouteStatus()!=null) {
			cr.setCargoRouteStatus(cargo.getCargoRouteStatus());
		}
		if(cargo.getCamion()!=null) {
			cr.setCamion(cargo.getCamion());
		}
		if(cargo.getFamproducto()!=null) {
			cr.setFamproducto(cargo.getFamproducto());
		}
		if(cargo.getCargoComments()!=null) {
			cr.setCargoComments(cargo.getCargoComments());
		}
		return repositorioCargo.save(cr);
		
	}
	
	//Obtener Datos
	public List<Cargo> obtenerDatosCargo() {
		List<Cargo> cargo;
		cargo=repositorioCargo.findAll();
		return cargo;
	}
	
	//ELIMINAR UN Cargp
	public Cargo eliminarCargo(Long codigo) throws Exception {
		Cargo cr;
		cr=repositorioCargo.getCargo(codigo);
		if(cr.getCodigo()!=null) {
			repositorioCargo.delete(cr);
		}else {
			throw new Exception();
		}
		return cr;
	}
	
	
	//OBTENER CARGO BY ID
	public Cargo obtenerCargo(Long codigo) throws Exception {
		Cargo cr;
		cr=repositorioCargo.getCargo(codigo);
		if(cr==null)throw new Exception("camion no encontrado");
		return cr;
	}

	//OBTENER CARGO BY PERSON CLIENT ID
	public List<Cargo> obtenerCargoByClientId(Long codigo) throws Exception {
		List<Cargo> cr;
		cr=repositorioCargo.getCargoByClientId(codigo);
		if(cr==null)throw new Exception("cargo no encontrado");
		return cr;
	}

	//OBTENER CARGO BY PERSON DRIVER ID
	public List<Cargo> obtenerCargoByDriverId(Long codigo) throws Exception {
		List<Cargo> cr;
		cr=repositorioCargo.getCargoByDriverId(codigo);
		if(cr==null)throw new Exception("cargo no encontrado");
		return cr;
	}

	//OBTENER CARGO BY PERSON CLIENT ID
	public List<Cargo> obtenerCargoByOperatorId(Long codigo) throws Exception {
		List<Cargo> cr;
		cr=repositorioCargo.getCargoByOperatortId(codigo);
		if(cr==null)throw new Exception("cargo no encontrado");
		return cr;
	}


}
