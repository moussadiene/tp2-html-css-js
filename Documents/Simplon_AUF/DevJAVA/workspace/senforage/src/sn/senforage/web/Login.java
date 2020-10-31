package sn.senforage.web;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.senforage.dao.UserRepository;
import sn.senforage.entities.User;


/**
 * Servlet implementation class Login
 */
@WebServlet(name = "login",urlPatterns = "/login")


public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy(HttpServletRequest request) {
		
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			
			request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String email = request.getParameter("email");
	    	String password = request.getParameter("password");
    		

	    	UserRepository userRepository = new UserRepository();
	    	User user = new User();
	    	user = userRepository.getUserByLog(email, password);
	    	
	    	if(user != null) {
	    		request.setAttribute( "user", user );
	    		HttpSession session = request.getSession(true); // permet d'initier la session 
	        	//session.invalidate(); 						// permet de supprimer le session
	        	session.setAttribute("user", user);
	        
	 			request.getRequestDispatcher("/WEB-INF/villages.jsp").forward(request, response);

	    	}else {
	    		request.setAttribute("name", "Email ou mot de passe invalide");
	    		doGet(request, response);

	    	}
		} catch (Exception e) {
			e.printStackTrace();
			doGet(request, response);
			
		}
		
	}

}
