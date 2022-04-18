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
@Table(name="Role_Function")
public class FuncionRol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RoleFunctionId")
	private Long codigo;
	private String roleFunctionWriteRead;
	
	@ManyToOne
	@JoinColumn(name="roleId")
	private Rol rol;
	@ManyToOne
	@JoinColumn(name="functionId")
	private Funcion funcion;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Funcion getFuncion() {
		return funcion;
	}
	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}
	public String getRoleFunctionWriteRead() {
		return roleFunctionWriteRead;
	}
	public void setRoleFunctionWriteRead(String roleFunctionWriteRead) {
		this.roleFunctionWriteRead = roleFunctionWriteRead;
	}
	
	

}
