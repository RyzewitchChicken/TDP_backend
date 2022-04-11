package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.upc.onticket.entity.Producto;

import pe.upc.onticket.repositorio.RepositorioProducto;



@Service
public class ServicioProducto {
	
	@Autowired RepositorioProducto repositorioProducto;
	
	
	/*registrar Producto*/
	@Transactional(rollbackFor= Exception.class)
	public Producto registrarProducto(Producto producto) throws Exception {
		if(producto.getCodigo()==null) {
			return repositorioProducto.save(producto);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public Producto actualizarProducto(Producto producto, Long codigo) throws Exception {
		Producto pr=repositorioProducto.getProducto(codigo);
		if(producto.getNombre()!=null) {
			pr.setNombre(producto.getNombre());
		}
		if(producto.getDescripcion()!=null) {
			pr.setDescripcion(producto.getDescripcion());
		}
		if(producto.getFamproducto()!=null) {
			pr.setFamproducto(producto.getFamproducto());
		}
		return repositorioProducto.save(pr);
		
	}
	
	//Obtener Datos
	public List<Producto> obtenerDatosProducto() {
		List<Producto> producto;
		producto=repositorioProducto.findAll();
		return producto;
	}
	
	//ELIMINAR UN PRODUCTO
	public Producto eliminarProducto(Long codigo) throws Exception {
		Producto pr;
		pr=repositorioProducto.getProducto(codigo);
		if(pr.getCodigo()!=null) {
			repositorioProducto.delete(pr);
		}else {
			throw new Exception();
		}
		return pr;
	}

}
