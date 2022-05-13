package pe.upc.onticket.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.upc.onticket.entity.Logs;

public interface RepositorioLogs extends JpaRepository<Logs,Long>{
	
	
	@Query("SELECT c FROM Logs c WHERE c.codigo=:codigo")
	Logs getLogs(@Param(value="codigo")Long codigo);

	@Query("SELECT c FROM Logs c WHERE c.cargo.codigo=:codigo")
	List<Logs> getLogsCargo(@Param(value="codigo")Long codigo);
}
