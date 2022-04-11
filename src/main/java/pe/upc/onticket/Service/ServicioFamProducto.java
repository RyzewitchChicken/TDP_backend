package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.onticket.entity.FamProducto;

import pe.upc.onticket.repositorio.RepositorioFamProducto;


@Service
public class ServicioFamProducto {
	
	@Autowired RepositorioFamProducto repositorioFamProducto;
	
	
	/*registrar FamProducto*/
	@Transactional(rollbackFor= Exception.class)
	public FamProducto registrarFamProducto(FamProducto famproducto) throws Exception {
		if(famproducto.getCodigo()==null) {
			return repositorioFamProducto.save(famproducto);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public FamProducto actualizarFamProducto(FamProducto famproducto, Long codigo) throws Exception {
		FamProducto fp=repositorioFamProducto.getFamProducto(codigo);
		if(famproducto.getNombre()!=null) {
			fp.setNombre(famproducto.getNombre());
		}
		if(famproducto.getTemperatura()!=0) {
			fp.setTemperatura(famproducto.getTemperatura());
		}
		if(famproducto.getHumedad()!=0) {
			fp.setHumedad(famproducto.getHumedad());
		}
		if(famproducto.getVelocidad()!=0) {
			fp.setVelocidad(famproducto.getVelocidad());
		}
		return repositorioFamProducto.save(fp);
		
	}
	
	//Obtener Datos
	public List<FamProducto> obtenerDatosFamProducto() {
		List<FamProducto> famproducto;
		famproducto=repositorioFamProducto.findAll();
		return famproducto;
	}
	
	//ELIMINAR UN FAMPRODUCTO
	public FamProducto eliminarFamProducto(Long codigo) throws Exception {
		FamProducto fr;
		fr=repositorioFamProducto.getFamProducto(codigo);
		if(fr.getCodigo()!=null) {
			repositorioFamProducto.delete(fr);
		}else {
			throw new Exception();
		}
		return fr;
	}

}
