package pe.upc.onticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="iot_Device")
public class Devices {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="iotDeviceId")
	private Long codigo;
	private String iotDeviceName;
	private String iotDeviceSerialNumber;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getIotDeviceName() {
		return iotDeviceName;
	}
	public void setIotDeviceName(String iotDeviceName) {
		this.iotDeviceName = iotDeviceName;
	}
	public String getIotDeviceSerialNumber() {
		return iotDeviceSerialNumber;
	}
	public void setIotDeviceSerialNumber(String iotDeviceSerialNumber) {
		this.iotDeviceSerialNumber = iotDeviceSerialNumber;
	}

	
	
	
	

}
