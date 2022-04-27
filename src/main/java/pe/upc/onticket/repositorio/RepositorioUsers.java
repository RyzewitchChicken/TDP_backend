package pe.upc.onticket.repositorio;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Users;

public interface RepositorioUsers extends JpaRepository<Users,Long>{
	@Query("SELECT c FROM Users c WHERE c.codigo=:codigo")
	Users getUsers(@Param(value="codigo")Long codigo);
	
	/*@Query("SELECT rol FROM Users c WHERE c.codigo=:codigo")
	Users getRoles(@Param(value="codigo")Long codigo);*/
	
	@Query("SELECT c.rol FROM Users c WHERE c.codigo=:codigo")
	List<Object[]> getRoles(@Param(value="codigo")Long codigo);
	
	@Query("SELECT c.user FROM Users c WHERE c.codigo=:codigo")
	List<Object[]> getPerson(@Param(value="codigo")Long codigo);

	@Query("SELECT c FROM Users c WHERE c.rol.codigo=:codigo")
	List<Users> getUserByRolId(@Param(value="codigo")Long codigo);

}
