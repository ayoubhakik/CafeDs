package metier.session;


import javax.ejb.Local;

//decrire que c'est une interface local
@Local
public interface IAbonnementLocal {
	public Boolean payerAbonnement(String numeroCart,String troixNbr,String dateExpiration,String montant);

}
