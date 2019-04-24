package melnychenko.vira.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class MuseumItems {
	@Id
	private int id;
	
	@Column(name = "museum_name")
	private String museumName;
	
	private String museumCountry;
	private String museumContinent;
	
	@Column(name = "museum_picture")
	private String museumPicture;
	
	private String museumAddress;
	private String museumWeb;
	private String museumDescription;
	private int idCountry;
	
	public int getIdCountry() {
		return idCountry;
	}
	public void setIdCountry(int idCountry) {
		this.idCountry = idCountry;
	}
	public String getMuseumContinent() {
		return museumContinent;
	}
	public void setMuseumContinent(String museumContinent) {
		this.museumContinent = museumContinent;
	}
	
	public String getMuseumAddress() {
		return museumAddress;
	}
	public void setMuseumAddress(String museumAddress) {
		this.museumAddress = museumAddress;
	}
	public String getMuseumWeb() {
		return museumWeb;
	}
	public void setMuseumWeb(String museumWeb) {
		this.museumWeb = museumWeb;
	}
	public String getMuseumDescription() {
		return museumDescription;
	}
	public void setMuseumDescription(String museumDescription) {
		this.museumDescription = museumDescription;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMuseumName() {
		return museumName;
	}
	public void setMuseumName(String museumName) {
		this.museumName = museumName;
	}
	public String getMuseumCountry() {
		return museumCountry;
	}
	public void setMuseumCountry(String museumCountry) {
		this.museumCountry = museumCountry;
	}
	public String getMuseumPicture() {
		return museumPicture;
	}
	public void setMuseumPicture(String museumPicture) {
		this.museumPicture = museumPicture;
	}
	
	
	
}
