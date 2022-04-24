package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.upc.onticket.entity.Users;
import pe.upc.onticket.repositorio.RepositorioUsers;



@Service
public class ServicioUsers {
	
	
	@Autowired RepositorioUsers repositorioUsers;
	
	
	/*registrar Users*/
	@Transactional(rollbackFor= Exception.class)
	public Users registrarUsers(Users users) throws Exception {
		if(users.getCodigo()==null) {
			return repositorioUsers.save(users);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public Users actualizarUsers(Users users, Long codigo) throws Exception {
		Users us=repositorioUsers.getUsers(codigo);
		if(users.getUserUsername()!=null) {
			us.setUserUsername(users.getUserUsername());
		}
		if(users.getUserPassword()!=null) {
			us.setUserPassword(users.getUserPassword());
		}
		if(users.getRol()!=null) {
			us.setRol(users.getRol());
		}
		if(users.getUser()!=null) {
			us.setUser(users.getUser());
		}
		return repositorioUsers.save(us);
		
	}
	
	//Obtener Datos
	public List<Users> obtenerDatosUsers() {
		List<Users> users;
		users=repositorioUsers.findAll();
		return users;
	}
	
	//ELIMINAR UN USERS
	public Users eliminarUsers(Long codigo) throws Exception {
		Users us;
		us=repositorioUsers.getUsers(codigo);
		if(us.getCodigo()!=null) {
			repositorioUsers.delete(us);
		}else {
			throw new Exception();
		}
		return us;
	}
	
	//OBTENER USERS BY ID
	public Users obtenerUsers(Long codigo) throws Exception {
		Users us;
		us=repositorioUsers.getUsers(codigo);
		if(us==null)throw new Exception("users no encontrado");
		return us;
	}
	
	/*//OBTENER ROLES BY ID
	public Users obtenerRoles(Long codigo) throws Exception {
		Users us;
		us=repositorioUsers.getRoles(codigo);
		if(us==null)throw new Exception("users no encontrado");
		return us;
	}*/
	//OBTENER ROLES BY ID
	public List<Object[]> obtenerRoles(Long codigo) throws Exception {
		List<Object[]> us;
		us=repositorioUsers.getRoles(codigo);
		if(us==null)throw new Exception("users no encontrado");
		return us;
	}
	
	//OBTENER PERSON BY ID
	public List<Object[]> obtenerPerson(Long codigo) throws Exception {
		List<Object[]> us;
		us=repositorioUsers.getPerson(codigo);
		if(us==null)throw new Exception("users no encontrado");
		return us;
	}

}
