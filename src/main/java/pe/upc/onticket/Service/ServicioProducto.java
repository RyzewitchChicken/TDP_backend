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
		if(producto.getProductName()!=null) {
			pr.setProductName(producto.getProductName());
		}
		if(producto.getProductDescription()!=null) {
			pr.setProductDescription(producto.getProductDescription());
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
	
	//OBTENER PRODUCTO BY ID
	public Producto obtenerProducto(Long codigo) throws Exception {
		Producto pr;
		pr=repositorioProducto.getProducto(codigo);
		if(pr==null)throw new Exception("famproducto no encontrado");
		return pr;
	}
	
	//OBTENER FAMPRODUCTO BY ID
	public List<Object[]> obtenerFamProducto(Long codigo) throws Exception {
		List<Object[]> pr;
		pr=repositorioProducto.getFamProducto(codigo);
		if(pr==null)throw new Exception("famproducto no encontrado");
		return pr;
	}

	//OBTENER PRODUCT BY FAMILIA
	public List<Producto> obtenerProductosPorFamilia(Long codigo) throws Exception {
		List<Producto> pr;
		pr=repositorioProducto.getProductsByFamProductoId(codigo);
		if(pr==null)throw new Exception("famproducto no encontrado");
		return pr;
	}

}
