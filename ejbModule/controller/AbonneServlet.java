package controller;

import java.io.IOException;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.entities.Abonne;
import metier.services.AbonneService;
import metier.services.AgentService;

//je vais utiliser les annotation pour le mapping
@WebServlet("/AgentServlet")  
public class AbonneServlet extends HttpServlet{
	
	@EJB
	private AbonneService ds;
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Session verification
		//with false. It will return null if not created yet.
		HttpSession session = req.getSession(false);

	    String url = req.getRequestURI().toString();
	    if(url.equals("/logout")) {
	    		//destruction of session
	    	    session.invalidate();
          	
	    	}

		
		if (session == null) {
			//go back to auth page
        	RequestDispatcher rd=req.getRequestDispatcher("/authentification.xhtml");
            rd.include(req, resp); 

		}
		else {
			//Otherwise, we will send user to payement page (agentPage)
			
        	RequestDispatcher rd=req.getRequestDispatcher("/abonnePage.xhtml");
            rd.include(req, resp); 


		}
        

        
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xhtml");
        
        HttpSession session = req.getSession(false);
		if (session == null) {
			//go back to auth page
        	RequestDispatcher rd=req.getRequestDispatcher("/authentification.xhtml");
            rd.include(req, resp); 

		}
		String numeroCart=(String) req.getAttribute("numeroCart");
		String troixNbr=(String) req.getAttribute("troixNbr");
		String dateExpiration=(String) req.getAttribute("dateExpiration");
		String montant=(String) req.getAttribute("montant");
		
		//now we will extract the actual date
		Date d=new Date();  
		
		if(ds.payerAbonnement(numeroCart, troixNbr, dateExpiration, montant)) {
			//in case of success
			RequestDispatcher rd=req.getRequestDispatcher("/successPage.xhtml");
            rd.include(req, resp); 
		}
		else {
			RequestDispatcher rd=req.getRequestDispatcher("/errorPage.xhtml");
            rd.include(req, resp); 
		}
		
		
		
		super.doPost(req, resp);
	}

	

	
}
