package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Rol;





public interface RepositorioRol extends JpaRepository<Rol,Long>{
	@Query("SELECT c FROM Rol c WHERE c.codigo=:codigo")
	Rol getRol(@Param(value="codigo")Long codigo);
}
