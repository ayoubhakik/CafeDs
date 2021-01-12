package metier.services;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.session.IAbonnementLocal;
@Stateless
@WebService
public class AbonneService {
	//pour l'injection de dependance
	@EJB 
	private IAbonnementLocal metier;
	@WebMethod
	public Boolean payerAbonnement(@WebParam(name="numeroCart")String numeroCart,
						@WebParam(name="troixNbr")String troixNbr,
						@WebParam(name="dateExpiration")Date dateExpiration,
						@WebParam(name="montant")Float montant) {
		return metier.payerAbonnement(numeroCart, troixNbr, dateExpiration, montant);
		}
}
