package pe.upc.onticket.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="Cargo")
public class Cargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cargoId")
	private Long codigo;
	private String cargoName;
	
	
	private Date cargoDate;
	
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime cargoHour;
	
	private String cargoInitialUbication;
	private String cargoFinalUbication;
	private String cargoStatus;
	
	@JsonFormat(pattern="HH:mm:ss")
	private LocalTime cargoRouteDuration;
	private String cargoRouteStatus;
	
	@ManyToOne
	@JoinColumn(name="truckId")
	private Camion camion;
	
	@ManyToOne
	@JoinColumn(name="familyProductId")
	private FamProducto famproducto;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getCargoName() {
		return cargoName;
	}
	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}

	
	


	public Date getCargoDate() {
		return cargoDate;
	}
	public void setCargoDate(Date cargoDate) {
		this.cargoDate = cargoDate;
	}
	public LocalTime getCargoHour() {
		return cargoHour;
	}
	public void setCargoHour(LocalTime cargoHour) {
		this.cargoHour = cargoHour;
	}
	public LocalTime getCargoRouteDuration() {
		return cargoRouteDuration;
	}
	public void setCargoRouteDuration(LocalTime cargoRouteDuration) {
		this.cargoRouteDuration = cargoRouteDuration;
	}
	public String getCargoInitialUbication() {
		return cargoInitialUbication;
	}
	public void setCargoInitialUbication(String cargoInitialUbication) {
		this.cargoInitialUbication = cargoInitialUbication;
	}
	public String getCargoFinalUbication() {
		return cargoFinalUbication;
	}
	public void setCargoFinalUbication(String cargoFinalUbication) {
		this.cargoFinalUbication = cargoFinalUbication;
	}
	public String getCargoStatus() {
		return cargoStatus;
	}
	public void setCargoStatus(String cargoStatus) {
		this.cargoStatus = cargoStatus;
	}
	public String getCargoRouteStatus() {
		return cargoRouteStatus;
	}
	public void setCargoRouteStatus(String cargoRouteStatus) {
		this.cargoRouteStatus = cargoRouteStatus;
	}
	
	
	
	public Camion getCamion() {
		return camion;
	}
	public void setCamion(Camion camion) {
		this.camion = camion;
	}
	public FamProducto getFamproducto() {
		return famproducto;
	}
	public void setFamproducto(FamProducto famproducto) {
		this.famproducto = famproducto;
	}
	
	
	
	


}
