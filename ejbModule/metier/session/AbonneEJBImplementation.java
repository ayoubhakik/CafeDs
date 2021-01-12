package metier.session;

import java.util.Date;

public class AbonneEJBImplementation implements IAbonnementLocal,IAbonnementRemote{

	@Override
	public Boolean payerAbonnement(String numeroCart, String troixNbr, Date dateExpiration, Float montant) {
		if(numeroCart.equals("0000000000000000") && troixNbr.equals("11/21"))
			
			return true;
		return false;
	}

}
