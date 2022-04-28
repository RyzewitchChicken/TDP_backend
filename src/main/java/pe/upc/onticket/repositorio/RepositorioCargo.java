package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Cargo;
import pe.upc.onticket.entity.Users;

import java.util.List;

public interface RepositorioCargo extends JpaRepository<Cargo,Long>{
	@Query("SELECT c FROM Cargo c WHERE c.codigo=:codigo")
	Cargo getCargo(@Param(value="codigo")Long codigo);

	@Query("SELECT c FROM Cargo c WHERE c.personClientId.codigo=:codigo")
	List<Cargo> getCargoByClientId(@Param(value="codigo")Long codigo);

	@Query("SELECT c FROM Cargo c WHERE c.personDriverId.codigo=:codigo")
	List<Cargo> getCargoByDriverId(@Param(value="codigo")Long codigo);

	@Query("SELECT c FROM Cargo c WHERE c.personOperatorId.codigo=:codigo")
	List<Cargo> getCargoByOperatortId(@Param(value="codigo")Long codigo);

}
