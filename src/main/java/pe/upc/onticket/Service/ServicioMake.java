package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.onticket.entity.Make;
import pe.upc.onticket.repositorio.RepositorioMake;


@Service
public class ServicioMake {
	
	@Autowired RepositorioMake repositorioMake;
	
	
	/*registrar Make*/
	@Transactional(rollbackFor= Exception.class)
	public Make registrarMake(Make make) throws Exception {
		if(make.getCodigo()==null) {
			return repositorioMake.save(make);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public Make actualizarMake(Make make, Long codigo) throws Exception {
		Make mk=repositorioMake.getMake(codigo);
		if(make.getMakeName()!=null) {
			mk.setMakeName(make.getMakeName());
		}

		return repositorioMake.save(mk);
		
	}
	
	//Obtener Datos
	public List<Make> obtenerDatosMake() {
		List<Make> make;
		make=repositorioMake.findAll();
		return make;
	}
	
	//ELIMINAR UN Make?
	public Make eliminarMake(Long codigo) throws Exception {
		Make mk;
		mk=repositorioMake.getMake(codigo);
		if(mk.getCodigo()!=null) {
			repositorioMake.delete(mk);
		}else {
			throw new Exception();
		}
		return mk;
	}

}
