package gg.sora.sora;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.javassist.bytecode.stackmap.BasicBlock.Catch;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

@Controller
public class LoginController {

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		req.setAttribute("contentPage", "login/login.jsp");
		return "index";
	}
	
//	@RequestMapping(value = "loginsuccess", method = RequestMethod.POST)
//	public String loginSuccess(HttpServletRequest req) {
//		req.setAttribute("contentPage", "login/loginsuccess.jsp");
//		return "index";
//	}
	
	@RequestMapping(value = "loginsuccess", method = RequestMethod.POST)
	public String callback(HttpServletRequest req) throws GeneralSecurityException, IOException {
			try {
				
			
			NetHttpTransport transport = new NetHttpTransport();
			JacksonFactory jsonFactory = new JacksonFactory();
			
		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
		    // Specify the CLIENT_ID of the app that accesses the backend:
		    .setAudience(Collections.singletonList("696606451912-1qpdbt2mgtl7lpnqn67pmrv3v5k2ocri.apps.googleusercontent.com"))
		    // Or, if multiple clients access the backend:
		    //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
		    .build();

		// (Receive idTokenString by HTTPS POST)

		String idTokenString = req.getParameter("idtoken");
		GoogleIdToken idToken = verifier.verify(idTokenString);
		
		if (idToken != null) {
		  Payload payload = idToken.getPayload();

		  // Print user identifier
		  String userId = payload.getSubject();
		  System.out.println("User ID: " + userId);

		  // Get profile information from payload
		  String email = payload.getEmail();
		  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
		  String name = (String) payload.get("name");
		  String pictureUrl = (String) payload.get("picture");
		  String locale = (String) payload.get("locale");
		  String familyName = (String) payload.get("family_name");
		  String givenName = (String) payload.get("given_name");

		  System.out.println(email);
		  
		  
		  // Use or store profile information
		  // ...
		  
		} else {
		  System.out.println("Invalid ID token.");
		}
			}catch (Exception e) {
				e.printStackTrace();
			}
		req.setAttribute("contentPage", "search.jsp");
			
				
					return "index";
		
	}
	
	
}
