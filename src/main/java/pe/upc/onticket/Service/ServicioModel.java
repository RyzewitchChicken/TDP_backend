package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.upc.onticket.entity.Model;
import pe.upc.onticket.repositorio.RepositorioModel;


@Service
public class ServicioModel {
	@Autowired RepositorioModel repositorioModel;
	
	
	/*registrar Model*/
	@Transactional(rollbackFor= Exception.class)
	public Model registrarModel(Model model) throws Exception {
		if(model.getCodigo()==null) {
			return repositorioModel.save(model);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public Model actualizarModel(Model model, Long codigo) throws Exception {
		Model md=repositorioModel.getModel(codigo);
		if(model.getModelName()!=null) {
			md.setModelName(model.getModelName());
		}
		if(model.getMake()!=null) {
			md.setMake(model.getMake());
		}

		return repositorioModel.save(md);
		
	}
	
	//Obtener Datos
	public List<Model> obtenerDatosModel() {
		List<Model> model;
		model=repositorioModel.findAll();
		return model;
	}
	
	//ELIMINAR UN Model?
	public Model eliminarModel(Long codigo) throws Exception {
		Model md;
		md=repositorioModel.getModel(codigo);
		if(md.getCodigo()!=null) {
			repositorioModel.delete(md);
		}else {
			throw new Exception();
		}
		return md;
	}
	
	//OBTENER Model BY ID
	public Model obtenerModel(Long codigo) throws Exception {
		Model md;
		md=repositorioModel.getModel(codigo);
		if(md==null)throw new Exception("model no encontrado");
		return md;
	}

}
