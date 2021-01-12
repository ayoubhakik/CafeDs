package metier.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import metier.entities.Abonne;
import metier.session.IAgentLocal;

@Stateless
@WebService
public class AgentService {
	@EJB
	private IAgentLocal metier;
	
	//on suppose que l'Agent va enregistrer tous les informations d'Abonne pour que l'abonne faire payer les abonnements
	@WebMethod
	public void addAbonne(@WebParam(name="username")String username,
						@WebParam(name="password")String password,
						@WebParam(name="nom")String nom,
						@WebParam(name="prenom")String prenom,
						@WebParam(name="montant")String numeroTele,Float montant) {
		Abonne a=new Abonne(username,password,nom,prenom,numeroTele,montant);
		metier.addAbonne(a);
		}
	@WebMethod
	public List<Abonne> getAllAbonne(){
		return metier.getAllAbonne();
	}
	
	@WebMethod
	//par defaut les methods sont webmethods,par contre il faut specifier les parametres avec webParam
	public Abonne getAbonne(@WebParam(name="id")int id) {
		return metier.getAbonne(id);
	}
	public void deleteAbonne(@WebParam(name="id")int id) {
		metier.deleteAbonne(id);
	}
	public Object authentication(@WebParam(name="username")String username,@WebParam(name="password")String password) {
		return metier.Authentication(username, password);
	}
	
	
}
