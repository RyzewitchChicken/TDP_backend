package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Make;

public interface RepositorioMake extends JpaRepository<Make,Long> {
	@Query("SELECT c FROM Make c WHERE c.codigo=:codigo")
	Make getMake(@Param(value="codigo")Long codigo);

}
