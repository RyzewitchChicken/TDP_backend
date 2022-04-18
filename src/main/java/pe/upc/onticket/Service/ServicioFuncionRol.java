package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.onticket.entity.FuncionRol;

import pe.upc.onticket.repositorio.RepositorioFuncionRol;


@Service
public class ServicioFuncionRol {
	@Autowired RepositorioFuncionRol repositorioFuncionRol;
	
	
	/*registrar funcionrol*/
	@Transactional(rollbackFor= Exception.class)
	public FuncionRol registrarFuncionRol(FuncionRol funcionrol) throws Exception {
		if(funcionrol.getCodigo()==null) {
			return repositorioFuncionRol.save(funcionrol);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public FuncionRol actualizarFuncionRol(FuncionRol funcionrol, Long codigo) throws Exception {
		FuncionRol fr=repositorioFuncionRol.getFuncionRol(codigo);
		if(funcionrol.getRol()!=null) {
			fr.setRol(funcionrol.getRol());
		}
		if(funcionrol.getFuncion()!=null) {
			fr.setFuncion(funcionrol.getFuncion());
		}
		if(funcionrol.getRoleFunctionWriteRead()!=null) {
			fr.setRoleFunctionWriteRead(funcionrol.getRoleFunctionWriteRead());
		}

		return repositorioFuncionRol.save(fr);
		
	}
	
	//Obtener Datos
	public List<FuncionRol> obtenerDatosFuncionRol() {
		List<FuncionRol> funcionrol;
		funcionrol=repositorioFuncionRol.findAll();
		return funcionrol;
	}
	
	
	//ELIMINAR UN FUNCROL
	public FuncionRol eliminarFuncionRol(Long codigo) throws Exception {
		FuncionRol fr;
		fr=repositorioFuncionRol.getFuncionRol(codigo);
		if(fr.getCodigo()!=null) {
			repositorioFuncionRol.delete(fr);
		}else {
			throw new Exception();
		}
		return fr;
	}

}
