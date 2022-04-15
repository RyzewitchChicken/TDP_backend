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
		if(user.getPersonName()!=null) {
			cam.setPersonName(user.getPersonName());
		}
		if(user.getPersonLastName()!=null) {
			cam.setPersonLastName(user.getPersonLastName());
		}
		if(user.getPersonCompany()!=null) {
			cam.setPersonCompany(user.getPersonCompany());
		}
		if(user.getPersonDocument()!=null) {
			cam.setPersonDocument(user.getPersonDocument());
		}
		if(user.getPersonBirthDate()!=null) {
			cam.setPersonBirthDate(user.getPersonBirthDate());
		}
		if(user.getPersonEmail()!=null) {
			cam.setPersonEmail(user.getPersonEmail());
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
