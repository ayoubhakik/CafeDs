package metier.session;


import javax.ejb.Remote;

//pour dire que c'est une interface remote
@Remote
public interface IAbonnementRemote {
	
	//pour effectuer le payement
	public Boolean payerAbonnement(String numeroCart,String troixNbr,String dateExpiration,String montant);
}
