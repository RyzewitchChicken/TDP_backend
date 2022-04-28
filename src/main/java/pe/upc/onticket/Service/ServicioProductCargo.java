package pe.upc.onticket.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import pe.upc.onticket.entity.Cargo;
import pe.upc.onticket.entity.ProductCargo;
import pe.upc.onticket.repositorio.RepositorioProductCargo;


@Service
public class ServicioProductCargo {
	
	@Autowired RepositorioProductCargo repositorioProductCargo;
	
	
	/*registrar ProductCargo*/
	@Transactional(rollbackFor= Exception.class)
	public ProductCargo registrarProductCargo(ProductCargo productcargo) throws Exception {
		if(productcargo.getCodigo()==null) {
			return repositorioProductCargo.save(productcargo);
		}else {
			throw new Exception();
		}
	}
	//Actualizar Datos
	public ProductCargo actualizarProductCargo(ProductCargo productcargo, Long codigo) throws Exception {
		ProductCargo pc=repositorioProductCargo.getProductCargo(codigo);
		if(productcargo.getProductCargoCrates()!=null) {
			pc.setProductCargoCrates(productcargo.getProductCargoCrates());
		}
		if(productcargo.getCargo()!=null) {
			pc.setCargo(productcargo.getCargo());
		}

		if(productcargo.getProducto()!=null) {
			pc.setProducto(productcargo.getProducto());
		}


		return repositorioProductCargo.save(pc);
		
	}
	
	//Obtener Datos
	public List<ProductCargo> obtenerDatosProductCargo() {
		List<ProductCargo> productcargo;
		productcargo=repositorioProductCargo.findAll();
		return productcargo;
	}
	
	//ELIMINAR UN PRODUCTOca
	public ProductCargo eliminarProductCargo(Long codigo) throws Exception {
		ProductCargo pc;
		pc=repositorioProductCargo.getProductCargo(codigo);
		if(pc.getCodigo()!=null) {
			repositorioProductCargo.delete(pc);
		}else {
			throw new Exception();
		}
		return pc;
	}
	
	//OBTENER PRODUCTOCa BY ID
	public ProductCargo obtenerProductCargo(Long codigo) throws Exception {
		ProductCargo pc;
		pc=repositorioProductCargo.getProductCargo(codigo);
		if(pc==null)throw new Exception("producto_cargo no encontrado");
		return pc;
	}

	//OBTENER PRODUCT_CARGO BY CARGO ID
	public List<ProductCargo> obtenerProductCargoByCargoId(Long codigo) throws Exception {
		List<ProductCargo> cr;
		cr=repositorioProductCargo.getProductCargoByCargoId(codigo);
		if(cr==null)throw new Exception("cargo no encontrado");
		return cr;
	}
}
