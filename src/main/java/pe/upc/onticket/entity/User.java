package pe.upc.onticket.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Person")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="personId")
	private Long codigo;
	private String personName;
	private String personLastName;
	private String personCompany;
	private String personDocument;
	private String  personBirthDate;
	private String personEmail;



	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getPersonLastName() {
		return personLastName;
	}
	public void setPersonLastName(String personLastName) {
		this.personLastName = personLastName;
	}
	public String getPersonCompany() {
		return personCompany;
	}
	public void setPersonCompany(String personCompany) {
		this.personCompany = personCompany;
	}
	public String getPersonDocument() {
		return personDocument;
	}
	public void setPersonDocument(String personDocument) {
		this.personDocument = personDocument;
	}
	public String getPersonBirthDate() {
		return personBirthDate;
	}
	public void setPersonBirthDate(String personBirthDate) {
		this.personBirthDate = personBirthDate;
	}
	public String getPersonEmail() {
		return personEmail;
	}
	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}





}
