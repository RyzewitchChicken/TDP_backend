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
@Table(name="\"Truck\"")
public class Camion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="truckId")
	private Long codigo;
	private String truckPlate;
	private String truckImage;
	
	
	@ManyToOne
	@JoinColumn(name="makeId")
	private Make make;
	
	@ManyToOne
	@JoinColumn(name="modelId")
	private Model model;
	
	@ManyToOne
	@JoinColumn(name="iotDeviceId")
	private Devices devices;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTruckPlate() {
		return truckPlate;
	}
	public void setTruckPlate(String truckPlate) {
		this.truckPlate = truckPlate;
	}
	public String getTruckImage() {
		return truckImage;
	}
	public void setTruckImage(String truckImage) {
		this.truckImage = truckImage;
	}
	public Make getMake() {
		return make;
	}
	public void setMake(Make make) {
		this.make = make;
	}
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	public Devices getDevices() {
		return devices;
	}
	public void setDevices(Devices devices) {
		this.devices = devices;
	}


	
	
	
}
