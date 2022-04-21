package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.upc.onticket.entity.Logs;
import pe.upc.onticket.repositorio.RepositorioLogs;


@Service
public class ServicioLogs {
	
	@Autowired RepositorioLogs repositorioLogs;
	
	
	/*registrar Logs*/
	@Transactional(rollbackFor= Exception.class)
	public Logs registrarLogs(Logs logs) throws Exception {
		if(logs.getCodigo()==null) {
			return repositorioLogs.save(logs);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public Logs actualizarLogs(Logs logs, Long codigo) throws Exception {
		Logs lg=repositorioLogs.getLogs(codigo);
		if(logs.getLogCargoDate()!=null) {
			lg.setLogCargoDate(logs.getLogCargoDate());
		}
		if(logs.getCargo()!=null) {
			lg.setCargo(logs.getCargo());
		}
		if(logs.getLogCargoHour()!=null) {
			lg.setLogCargoHour(logs.getLogCargoHour());
		}
		if(logs.getLogCargoUbication()!=null) {
			lg.setLogCargoUbication(logs.getLogCargoUbication());
		}
		if(logs.getLogCargoTemperature()!=null) {
			lg.setLogCargoTemperature(logs.getLogCargoTemperature());
		}
		if(logs.getLogCargoHumidity()!=null) {
			lg.setLogCargoHumidity(logs.getLogCargoHumidity());
		}
		if(logs.getLogCargoVelocity()!=null) {
			lg.setLogCargoVelocity(logs.getLogCargoVelocity());
		}


		return repositorioLogs.save(lg);
		
	}
	
	//Obtener Datos
	public List<Logs> obtenerDatosLogs() {
		List<Logs> logs;
		logs=repositorioLogs.findAll();
		return logs;
	}
	
	//ELIMINAR UN LOGS
	public Logs eliminarLogs(Long codigo) throws Exception {
		Logs lg;
		lg=repositorioLogs.getLogs(codigo);
		if(lg.getCodigo()!=null) {
			repositorioLogs.delete(lg);
		}else {
			throw new Exception();
		}
		return lg;
	}
	
	//OBTENER LOGS BY ID
	public Logs obtenerLogs(Long codigo) throws Exception {
		Logs lg;
		lg=repositorioLogs.getLogs(codigo);
		if(lg==null)throw new Exception("log no encontrado");
		return lg;
	}

}
