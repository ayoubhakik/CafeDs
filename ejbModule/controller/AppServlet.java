package controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.entities.Abonne;
import metier.services.AbonneService;
import metier.services.AgentService;

@WebServlet("/AppServlet")  
public class AppServlet extends HttpServlet {

	
	@EJB
	private AgentService ds;
	
	
	private static final long serialVersionUID = 1L;

	
	public AppServlet() {
		super();
	}
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
        
        String url = req.getRequestURI().toString();
        
        //initialisation des pages
        if(url.equals("/auth")) {
        	RequestDispatcher rd=req.getRequestDispatcher("/authentification.xhtml");  
            rd.include(req, resp);  
        }
        
        
        
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/xhtml");
        
        //garantir le recoit des params
	    String username=req.getParameter("username");  
	    String password=req.getParameter("password"); 
	    
	    Object obj=(Object)ds.authentication(username, password);
	    
	    //en cas d'echec d'authentification
	    if(obj==null) {
        	RequestDispatcher rd=req.getRequestDispatcher("/authentification.xhtml");
	    }
	    
		if((obj.getClass().toString()).equals("Agent")) {
			
			HttpSession session=req.getSession();  
			//la seule information qu on est besoin est le role pour garder la session d'agent 
			session.setAttribute("role","agent" );
			RequestDispatcher rd=req.getRequestDispatcher("/agentPage.xhtml");  
            rd.include(req, resp); 
			
	    }
		
		if((obj.getClass().toString()).equals("Abonne")) {
			
			HttpSession session=req.getSession();  
			//on envoi l'Abonne vers la page abonnePage
			session.setAttribute("Abonne",(Abonne)obj);
			RequestDispatcher rd=req.getRequestDispatcher("/abonnePage.xhtml");  
            rd.include(req, resp); 
	    }
		
		
		super.doPost(req, resp);
	}

	

	

}
