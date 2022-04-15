package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Users;

public interface RepositorioUsers extends JpaRepository<Users,Long>{
	@Query("SELECT c FROM Users c WHERE c.codigo=:codigo")
	Users getUsers(@Param(value="codigo")Long codigo);

}
