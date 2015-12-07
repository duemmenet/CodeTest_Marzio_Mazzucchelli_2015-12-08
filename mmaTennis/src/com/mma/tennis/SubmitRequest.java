package com.mma.tennis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import java.security.cert.X509Certificate;
import java.util.Random;

import javax.net.ssl.X509TrustManager;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SubmitRequest  extends HttpServlet { 


	private static final long serialVersionUID = 8005337661174731068L;
	

	
	Player player1 ;
    Player player2 ;
    Tennis game ;
 
    
    public void init(ServletConfig config) throws ServletException {
     	player1 = new Player("player1");
		player2 = new Player("player2");
        game = new Tennis(player1, player2);   
        game.getScore();
      } 
    
    
    private void pointRnd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    
		
		Random rn = new Random();
    	int res = rn.nextInt(2) + 1;
    	if (res == 1) {
    	 	player1.winBall();
    	}else {
    		player2.winBall();
    	}
    	
    	
       
      
    	
    }
    
    private void playIt(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
    	String res = null ;
		try {
			res = game.getScore();
			request.getSession().setAttribute("res", res);
		} catch (Exception ex) {
			request.getSession().setAttribute("res", "Game over " + ex);			
		} 

		if (game.getOff()=="x"){
			request.getSession().setAttribute("dis", "disabled");
		}else {
			request.getSession().setAttribute("dis", "");
		}
	
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	
		
    }
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		
		String who = request.getParameter("WHO");
		if ("1".equals(who)){
			player1.winBall();
		}else if  ("2".equals(who)){
			player2.winBall();
		} else if  ("0".equals(who)){ 		
			player1 = new Player("player1");
			player2 = new Player("player2");
			game = new Tennis(player1, player2);			
		} else {
			//auto 
				
			
			pointRnd(request,response);
		}
		
		playIt(request, response);
		
	}

	
}
