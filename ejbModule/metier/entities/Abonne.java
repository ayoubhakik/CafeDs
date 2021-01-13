package metier.entities;

import java.io.Serializable;
import java.lang.Float;
import java.lang.String;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Abonne
 *
 */
@Entity
@Table(name="ABONNES")
public class Abonne implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String username;
	private String nom;
	private String prenom;
	private Float montant;
	private String numero;
	private String cartNum;
	private String dateExpiration;
	private String troisNbr;
	private static final long serialVersionUID = 1L;

	public Abonne() {
		super();
	}  
	public Abonne(String username,String password,String nom,String prenom,String numeroTele,Float montant) {
		super();
		this.username=username;
		this.nom=nom;
		this.prenom=prenom;
		this.numero=numeroTele;
		this.montant=montant;
	}
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public Float getMontant() {
		return this.montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}   
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}   
	public String getCartNum() {
		return this.cartNum;
	}

	public void setCartNum(String cartNum) {
		this.cartNum = cartNum;
	}   
	public String getDateExpiration() {
		return this.dateExpiration;
	}

	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}   
	public String getTroisNbr() {
		return this.troisNbr;
	}

	public void setTroisNbr(String troisNbr) {
		this.troisNbr = troisNbr;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
   
}
