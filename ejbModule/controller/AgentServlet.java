package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.entities.Abonne;
import metier.services.AgentService;

@WebServlet("/AgentServlet")  
public class AgentServlet extends HttpServlet{

	@EJB
	private AgentService ds;
	
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
                
      //Session verification
      		//with false. It will return null if not created yet.
      		HttpSession session = req.getSession(false);
      		if (session == null) {
      			//go back to auth page
              	RequestDispatcher rd=req.getRequestDispatcher("/authentification.xhtml");

      		}
      		else {
      			//Otherwise, we will send List of Abonnes to our page(table)
      			req.setAttribute("Abonnes", ds.getAllAbonne());
      	        String url = req.getRequestURI().toString();
      	        
      	        if(url.equals("/addAbonne")) {
      	        	Float montant=(Float)req.getAttribute("montant");
      	        	String username=(String)req.getAttribute("username");
      	        	String password=(String)req.getAttribute("password");
      	        	String nom=(String)req.getAttribute("nom");
      	        	String prenom=(String)req.getAttribute("prenom");
      	        	String numeroTele=(String)req.getAttribute("numeroTele");
      	        	
      	        	ds.addAbonne(username, password, nom, prenom, numeroTele, montant);

      	        	
      	        }
      	        if(url.equals("/deleteAbonne")) {
    	        	int id=(int)req.getAttribute("id");
    	        	ds.deleteAbonne(id);
    	        }
	      	    if(url.equals("/logout")) {
	      	    		//destruction of session
	      	    	    session.invalidate();
		              	
	      	    	}

	            RequestDispatcher rd=req.getRequestDispatcher("/authentification.xhtml");

	  	        }
	      	    
              	RequestDispatcher rd=req.getRequestDispatcher("/agentPage.xhtml");

      		
        
		super.doGet(req, resp);
	}

	
	

	
}
