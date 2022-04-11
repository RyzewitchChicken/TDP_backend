package pe.upc.onticket.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import pe.upc.onticket.entity.Devices;

public interface RepositorioDevice extends JpaRepository<Devices,Long>{
	@Query("SELECT c FROM Devices c WHERE c.codigo=:codigo")
	Devices getDevice(@Param(value="codigo")Long codigo);

}
