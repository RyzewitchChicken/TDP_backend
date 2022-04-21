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
		if(famproducto.getFamilyProductName()!=null) {
			fp.setFamilyProductName(famproducto.getFamilyProductName());
		}
		if(famproducto.getFamilyProductTemperatureMin()!=0) {
			fp.setFamilyProductTemperatureMin(famproducto.getFamilyProductTemperatureMin());
		}
		if(famproducto.getFamilyProductTemperatureMax()!=0) {
			fp.setFamilyProductTemperatureMax(famproducto.getFamilyProductTemperatureMax());
		}
		if(famproducto.getFamilyProductHumidityMin()!=0) {
			fp.setFamilyProductHumidityMin(famproducto.getFamilyProductHumidityMin());
		}
		if(famproducto.getFamilyProductHumidityMax()!=0) {
			fp.setFamilyProductHumidityMax(famproducto.getFamilyProductHumidityMax());
		}
		if(famproducto.getFamilyProductVelocityMax()!=0) {
			fp.setFamilyProductVelocityMax(famproducto.getFamilyProductVelocityMax());
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
	
	//OBTENER FAMPRODUCTO BY ID
	public FamProducto obtenerFamProducto(Long codigo) throws Exception {
		FamProducto fr;
		fr=repositorioFamProducto.getFamProducto(codigo);
		if(fr==null)throw new Exception("camion no encontrado");
		return fr;
	}

}
