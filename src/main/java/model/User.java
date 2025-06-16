package model;

public class User {
	private String nom;
	private String email;
	private String prenom;
	private String telephone;
	private String role;


	

	public User(String nom, String email, String prenom, String telephone, String role) {
		this.nom = nom;
		this.email = email;
		this.prenom = prenom;
		this.telephone = telephone;
		this.role = role;
	}




	public String getNom() {
		return nom;
	}




	public void setNom(String nom) {
		this.nom = nom;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPrenom() {
		return prenom;
	}




	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}




	public String getTelephone() {
		return telephone;
	}




	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}
	
	
	

}
