package fr.eni.encheres.bo;

import java.time.LocalDate;

public class ListeEncheres {

	private String titre;
	private int prix;
	private LocalDate finEnchere;
	private String nomVendeur;
	
	public ListeEncheres(String titre, int prix, LocalDate finEnchere, String nomVendeur) {
		this.titre = titre;
		this.prix = prix;
		this.finEnchere = finEnchere;
		this.nomVendeur = nomVendeur;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public LocalDate getFinEnchere() {
		return finEnchere;
	}

	public void setFinEnchere(LocalDate finEnchere) {
		this.finEnchere = finEnchere;
	}

	public String getNomVendeur() {
		return nomVendeur;
	}

	public void setNomVendeur(String nomVendeur) {
		this.nomVendeur = nomVendeur;
	}
	
	
}
