package sn.senforage.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sn.senforage.dao.ClientRepository;
import sn.senforage.dao.JpaRepository;
import sn.senforage.dao.VillageRepository;
import sn.senforage.entities.Client;
import sn.senforage.entities.Village;

/**
 * Servlet implementation class Client
 */
@WebServlet(name = "clients" ,urlPatterns = "/clients" )
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true); // permet d'initier la session 
		if(session==null) {
 			request.getRequestDispatcher("index.jsp").forward(request, response);
    	}else {
			JpaRepository<Client> clientRepository = new ClientRepository();
			JpaRepository<Village> villageRepository = new VillageRepository();
		
			List<Client> clients = new ArrayList<Client>();
			List<Village> villages = new ArrayList<Village>();
			
			clients =  clientRepository.findAll();
			villages =  villageRepository.findAll();
			
			request.setAttribute( "villages", villages);
			request.setAttribute( "clients", clients);
			
			request.getServletContext().getRequestDispatcher("/WEB-INF/clients2.jsp").forward(request, response);
    	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true); // permet d'initier la session 
		if(session==null) {
 			request.getRequestDispatcher("index.jsp").forward(request, response);
    	}else {
		try {
			
			JpaRepository<Client> clientRepository = new ClientRepository();
			Client client = new Client();
			client.setNomFamille(request.getParameter("nom"));
			client.setAdresse(request.getParameter("adresse"));
			client.setTelephone(request.getParameter("telephone"));
			
			JpaRepository<Village> villageRepository = new VillageRepository();
			Village village = new Village();
			village = villageRepository.get(Integer.parseInt(request.getParameter("village_id")));
			client.setVillage(village);
			int ok = clientRepository.add(client);
			if(ok ==1) {
				request.setAttribute("resultat", "Ajout");
			}else {
				request.setAttribute("resultat", "Erreur");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		doGet(request, response);
		// TODO Auto-generated method stub
		// doGet(request, response);
    	}
		}

}
