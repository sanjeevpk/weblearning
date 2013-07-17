package com;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

/**
 * Servlet implementation class FacebookPost
 */
@WebServlet("/FacebookPost")
public class FacebookPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FacebookPost() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Facebook facebook = new FacebookFactory().getInstance();
		facebook.setOAuthAppId("45742386593", "e5a1777095634ffe9bf697030518f166");
		facebook.setOAuthPermissions("email, publish_stream");
		facebook.setOAuthAccessToken(new AccessToken("CAACEdEose0cBAH0vOyl1rIA90kWqcYGYulsdGsrpgwrTuyZBFyEqCtcBpiPZB6sc6ZCrPD0AeRKnz8d1jYlqGJHSDTO6sA5w0ZCvcxUZB9y3XovgHxftjvqZARK2uZCwuodbgsD6mfoApCCn0DZAdYHqBgqgmsTVU3pZBpOyjvm49ugZDZD", null));
		try {
			facebook.postStatusMessage("Hello World from Facebook4J.");
		} catch (FacebookException e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
	}

}
