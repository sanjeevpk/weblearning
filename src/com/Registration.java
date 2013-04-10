package com;



import java.io.IOException;
import org.apache.log4j.Logger;
import org.apache.log4j.pattern.LogEvent;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	RegistrationService registrationService;
	private static final Logger logger = Logger.getLogger(Registration.class);
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	
    	super.init(config);
    	WebApplicationContext factory =  WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
    	registrationService = factory.getBean(RegistrationService.class);
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("nameTextField");
		String email = request.getParameter("emailTextField");
		
		System.out.println("Name -->>"+name);
		System.out.println("Email -->>"+email);
		
		log("Log4j logging starting...");
		
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		
		System.out.println("Name -->>"+user.getName());
		System.out.println("Email -->>"+user.getEmail());
		logger.debug("Name-->>"+user.getName());
		logger.debug("Email -->>"+user.getEmail());			
		boolean saved = registrationService.saveNewRegistration(user);//ServiceFactory.getRegistrationService().saveNewRegistration(user);
		if(saved){
			System.out.println("Saved!!!");
		}
		else {
			System.out.println("Not Saved...");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
