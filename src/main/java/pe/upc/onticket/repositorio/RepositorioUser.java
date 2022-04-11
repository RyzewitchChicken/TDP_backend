package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import pe.upc.onticket.entity.User;

public interface RepositorioUser extends JpaRepository<User,Long>{
	@Query("SELECT c FROM User c WHERE c.codigo=:codigo")
	User getUser(@Param(value="codigo")Long codigo);

}
