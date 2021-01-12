package metier.session;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.entities.Abonne;
import metier.entities.User;

public class AgentEJBImplementation implements IAgentRemote,IAgentLocal{
	
	//injecter l'unite de persistence via persistenceContext
	@PersistenceContext
	private EntityManager em;
	@Override
	public void addAbonne(Abonne a) {
		//le conteneur EJB qui va gerer la persistence
		em.persist(a);
		
	}

	@Override
	public List<Abonne> getAllAbonne() {
		Query req=em.createNativeQuery("select A from Abonne A");
		return req.getResultList();
	}

	@Override
	public Abonne getAbonne(int id) {
		Abonne a=em.find(Abonne.class, id);
		//en ca d'echec
		if(a==null) throw new RuntimeException("Compte n'existe pas");
		return a;
	}

	@Override
	public void updateAbonne(Abonne a) {
		em.merge(a);
	}

	@Override
	public void deleteAbonne(int id) {
		Abonne a=getAbonne(id);
		em.remove(a);
	}

	@Override
	public Object Authentication(String username, String password) {
		User user=(User) em.createQuery("select U from User U where username="+username+" and password ="+password);
		
		//if user is not found then return null
		if(user.getRole()==null)
			return null;
		//if user exist and its role is agent then return agent object
		if(user.getRole().equals("agent"))
			return user;
		
		//otherwise we are handling an Abonne
		Abonne a=(Abonne) em.createQuery("select A from Abonne A where username="+username);
			return a;
	}

	

}
