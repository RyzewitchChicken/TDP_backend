package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Cargo;

public interface RepositorioCargo extends JpaRepository<Cargo,Long>{
	@Query("SELECT c FROM Cargo c WHERE c.codigo=:codigo")
	Cargo getCargo(@Param(value="codigo")Long codigo);

}
