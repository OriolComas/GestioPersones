package Model;

public class Persona implements Comparable<Persona> {

	private String dni;
	private String nom;
	private String PrimerCognom;
	private String SegonCognom;
	private int edat;
	
	
	public Persona(String dni, String nom, String primerCognom,
			String segonCognom, int edat) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.PrimerCognom = primerCognom;
		this.SegonCognom = segonCognom;
		this.edat = edat;
	}


	public String getNom() {
		return nom;
	}


	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nom=" + nom + ", PrimerCognom="
				+ PrimerCognom + ", SegonCognom=" + SegonCognom + ", edat="
				+ edat + "]";
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public String getPrimerCognom() {
		return PrimerCognom;
	}


	public void setPrimerCognom(String primerCognom) {
		PrimerCognom = primerCognom;
	}


	public String getSegonCognom() {
		return SegonCognom;
	}


	public void setSegonCognom(String segonCognom) {
		SegonCognom = segonCognom;
	}


	public int getEdat() {
		return edat;
	}


	public void setEdat(int edat) {
		this.edat = edat;
	}


	@Override
	public int compareTo(Persona persona) {
		// TODO Auto-generated method stub
		return this.dni.compareTo(persona.dni);
	}
	
}
