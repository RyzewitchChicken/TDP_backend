package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Model;

public interface RepositorioModel extends JpaRepository<Model,Long>{
	@Query("SELECT c FROM Model c WHERE c.codigo=:codigo")
	Model getModel(@Param(value="codigo")Long codigo);

}
