package metier.session;

import java.util.List;

import javax.ejb.Local;

import metier.entities.Abonne;

@Local
public interface IAgentLocal {
	
	
	//add a subscriber
	public void addAbonne(Abonne a);
	
	//used to list our existed subscriber
	public List<Abonne> getAllAbonne();
	
	//get one subscriber using his id
	public Abonne getAbonne(int id);
	
	//update of the subscriber
	public void updateAbonne(Abonne a);
	
	//delete of a subscriber
	public void deleteAbonne(int a);
	
	//authentication
	//we will verify if the user exists, then get the object by role. Otherwise we return null
	public Object Authentication(String username,String password);
		
}
