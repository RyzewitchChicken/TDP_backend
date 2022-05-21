package pe.upc.onticket.entity;


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

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="Logs")
public class Logs {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="logId")
	private Long codigo;
	private String logCargoDate;
	private String logCargoHour;
	private String logCargoUbication;
	private String logCargoTemperature;
	private String logCargoHumidity;
	private String logCargoVelocity;
	private Integer logCargoAlertType;
	
	
	@ManyToOne
	@JoinColumn(name="cargoId")
	private Cargo cargo;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getLogCargoDate() {
		return logCargoDate;
	}
	public void setLogCargoDate(String logCargoDate) {
		this.logCargoDate = logCargoDate;
	}
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	
	public String getLogCargoHour() {
		return logCargoHour;
	}
	public void setLogCargoHour(String logCargoHour) {
		this.logCargoHour = logCargoHour;
	}
	public String getLogCargoUbication() {
		return logCargoUbication;
	}
	public void setLogCargoUbication(String logCargoUbication) {
		this.logCargoUbication = logCargoUbication;
	}
	public String getLogCargoTemperature() {
		return logCargoTemperature;
	}
	public void setLogCargoTemperature(String logCargoTemperature) {
		this.logCargoTemperature = logCargoTemperature;
	}
	public String getLogCargoHumidity() {
		return logCargoHumidity;
	}
	public void setLogCargoHumidity(String logCargoHumidity) {
		this.logCargoHumidity = logCargoHumidity;
	}
	public String getLogCargoVelocity() {
		return logCargoVelocity;
	}
	public void setLogCargoVelocity(String logCargoVelocity) {
		this.logCargoVelocity = logCargoVelocity;
	}
	public Integer isLogCargoAlertType() {
		return logCargoAlertType;
	}
	public void setLogCargoAlertType(Integer logCargoAlertType) {
		this.logCargoAlertType = logCargoAlertType;
	}

	
	
	
}
