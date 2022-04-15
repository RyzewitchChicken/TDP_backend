package pe.upc.onticket.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="FamilyProduct")
public class FamProducto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="familyProductId")
	private Long codigo;
	private String familyProductName;
	private double familyProductTemperatureMin;
	private double familyProductTemperatureMax;
	private double familyProductHumidityMin;
	private double familyProductHumidityMax;
	private double familyProductVelocityMax;	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getFamilyProductName() {
		return familyProductName;
	}
	public void setFamilyProductName(String familyProductName) {
		this.familyProductName = familyProductName;
	}
	public double getFamilyProductTemperatureMin() {
		return familyProductTemperatureMin;
	}
	public void setFamilyProductTemperatureMin(double familyProductTemperatureMin) {
		this.familyProductTemperatureMin = familyProductTemperatureMin;
	}
	public double getFamilyProductTemperatureMax() {
		return familyProductTemperatureMax;
	}
	public void setFamilyProductTemperatureMax(double familyProductTemperatureMax) {
		this.familyProductTemperatureMax = familyProductTemperatureMax;
	}
	public double getFamilyProductHumidityMin() {
		return familyProductHumidityMin;
	}
	public void setFamilyProductHumidityMin(double familyProductHumidityMin) {
		this.familyProductHumidityMin = familyProductHumidityMin;
	}
	public double getFamilyProductHumidityMax() {
		return familyProductHumidityMax;
	}
	public void setFamilyProductHumidityMax(double familyProductHumidityMax) {
		this.familyProductHumidityMax = familyProductHumidityMax;
	}
	public double getFamilyProductVelocityMax() {
		return familyProductVelocityMax;
	}
	public void setFamilyProductVelocityMax(double familyProductVelocityMax) {
		this.familyProductVelocityMax = familyProductVelocityMax;
	}

	
	
	

}
