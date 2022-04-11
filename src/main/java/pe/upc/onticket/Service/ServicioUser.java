package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.onticket.entity.User;

import pe.upc.onticket.repositorio.RepositorioUser;

@Service
public class ServicioUser {
	
	
	@Autowired RepositorioUser repositorioUser;
	
	
	/*registrar User*/
	@Transactional(rollbackFor= Exception.class)
	public User registrarUser(User user) throws Exception {
		if(user.getCodigo()==null) {
			return repositorioUser.save(user);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public User actualizarUser(User user, Long codigo) throws Exception {
		User cam=repositorioUser.getUser(codigo);
		if(user.getUsuario()!=null) {
			cam.setUsuario(user.getUsuario());
		}
		if(user.getNombre()!=null) {
			cam.setNombre(user.getNombre());
		}
		if(user.getApellido()!=null) {
			cam.setApellido(user.getApellido());
		}
		if(user.getContraseña()!=null) {
			cam.setContraseña(user.getContraseña());
		}
		if(user.getFecha_nacimiento()!=null) {
			cam.setFecha_nacimiento(user.getFecha_nacimiento());
		}
		if(user.getRol()!=null) {
			cam.setRol(user.getRol());
		}
		return repositorioUser.save(cam);
		
	}
	
	//Obtener Datos
	public List<User> obtenerDatosUser() {
		List<User> user;
		user=repositorioUser.findAll();
		return user;
	}
	
	//ELIMINAR UN USER
	public User eliminarUser(Long codigo) throws Exception {
		User us;
		us=repositorioUser.getUser(codigo);
		if(us.getCodigo()!=null) {
			repositorioUser.delete(us);
		}else {
			throw new Exception();
		}
		return us;
	}

}
