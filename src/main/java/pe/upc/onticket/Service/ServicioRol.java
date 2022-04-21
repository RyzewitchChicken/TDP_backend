package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.upc.onticket.entity.Rol;

import pe.upc.onticket.repositorio.RepositorioRol;


@Service
public class ServicioRol {
	
	@Autowired RepositorioRol repositorioRol;
	
	
	/*registrar rol*/
	@Transactional(rollbackFor= Exception.class)
	public Rol registrarRol(Rol rol) throws Exception {
		if(rol.getCodigo()==null) {
			return repositorioRol.save(rol);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public Rol actualizarRol(Rol rol, Long codigo) throws Exception {
		Rol r=repositorioRol.getRol(codigo);
		if(rol.getRoleName()!=null) {
			r.setRoleName(rol.getRoleName());
		}

		return repositorioRol.save(r);
		
	}
	
	//Obtener Datos
	public List<Rol> obtenerDatosRol() {
		List<Rol> rol;
		rol=repositorioRol.findAll();
		return rol;
	}
	
	//OBTENER ROL BY ID
	public Rol obtenerRol(Long codigo) throws Exception {
		Rol r;
		r=repositorioRol.getRol(codigo);
		if(r==null)throw new Exception("rol no  encontrado");
		return r;
	}
	
	
	//ELIMINAR UN ROL
	public Rol eliminarRol(Long codigo) throws Exception {
		Rol c;
		c=repositorioRol.getRol(codigo);
		if(c.getCodigo()!=null) {
			repositorioRol.delete(c);
		}else {
			throw new Exception();
		}
		return c;
	}

}
