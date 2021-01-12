package metier.session;

import java.util.Date;

import javax.ejb.Local;

//decrire que c'est une interface local
@Local
public interface IAbonnementLocal {
	public Boolean payerAbonnement(String numeroCart,String troixNbr,Date dateExpiration,Float montant);

}
