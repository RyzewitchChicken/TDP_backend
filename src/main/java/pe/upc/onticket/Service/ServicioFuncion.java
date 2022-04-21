package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.onticket.entity.Funcion;

import pe.upc.onticket.repositorio.RepositorioFuncion;


@Service
public class ServicioFuncion {
	
	@Autowired RepositorioFuncion repositorioFuncion;
	
	
	/*registrar Funcion*/
	@Transactional(rollbackFor= Exception.class)
	public Funcion registrarFuncion(Funcion funcion) throws Exception {
		if(funcion.getCodigo()==null) {
			return repositorioFuncion.save(funcion);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public Funcion actualizarFuncion(Funcion funcion, Long codigo) throws Exception {
		Funcion func=repositorioFuncion.getFuncion(codigo);
		if(funcion.getFunctionName()!=null) {
			func.setFunctionName(funcion.getFunctionName());
		}
	
		return repositorioFuncion.save(func);
		
	}
	
	//Obtener Datos
	public List<Funcion> obtenerDatosFuncion() {
		List<Funcion> funcion;
		funcion=repositorioFuncion.findAll();
		return funcion;
	}
	
	//ELIMINAR UNA FUNCION
	public Funcion eliminarFuncion(Long codigo) throws Exception {
		Funcion f;
		f=repositorioFuncion.getFuncion(codigo);
		if(f.getCodigo()!=null) {
			repositorioFuncion.delete(f);
		}else {
			throw new Exception();
		}
		return f;
	}
	
	//OBTENER Funcion BY ID
	public Funcion obtenerFuncion(Long codigo) throws Exception {
		Funcion f;
		f=repositorioFuncion.getFuncion(codigo);
		if(f==null)throw new Exception("funcion no encontrado");
		return f;
	}

}
