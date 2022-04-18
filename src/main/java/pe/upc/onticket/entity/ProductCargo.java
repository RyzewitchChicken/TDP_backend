package pe.upc.onticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Product_Cargo")
public class ProductCargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ProductCargoId")
	private Long codigo;
	private String productCargoCrates;
	
	@ManyToOne
	@JoinColumn(name="cargoId")
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name="productId")
	private Producto producto;

	
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getProductCargoCrates() {
		return productCargoCrates;
	}

	public void setProductCargoCrates(String productCargoCrates) {
		this.productCargoCrates = productCargoCrates;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
	


}
