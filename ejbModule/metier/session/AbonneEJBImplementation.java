package metier.session;

import java.util.Date;

public class AbonneEJBImplementation implements IAbonnementLocal,IAbonnementRemote{

	
	@Override
	public Boolean payerAbonnement(String numeroCart, String troixNbr, String dateExpiration, String montant) {
		// TODO Auto-generated method stub
			if(numeroCart.equals("0000000000000000") && troixNbr.equals("11/21"))
			
			return true;
		return false;
	}

}
