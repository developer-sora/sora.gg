package gg.sora.sora;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gg.sora.dao.DAO;
import gg.sora.dao.LoginDAO;
import gg.sora.dao.RankerRateDAO;
import gg.sora.dao.timelineDAO;
<<<<<<< HEAD
=======
import gg.sora.dto.tip;
>>>>>>> branch 'main' of https://github.com/developer-sora/sora.gg.majimak.git
import gg.sora.dto.userID;
import gg.sora.otherDTO.GameId;
import gg.sora.otherDTO.challchampban;
import gg.sora.otherDTO.challchampick;
import gg.sora.otherDTO.challlist;

@Controller
public class HomeController {

	@Autowired
	private DAO dao;
	@Autowired
	private timelineDAO tdao;
	@Autowired
	private RankerRateDAO rdao;
	@Autowired
	private LoginDAO ldao;
<<<<<<< HEAD

=======
>>>>>>> branch 'main' of https://github.com/developer-sora/sora.gg.majimak.git

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		req.setAttribute("contentPage", "search.jsp");
		return "index";
	}

	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String home2(HttpServletRequest req) {
		req.setAttribute("contentPage", "search.jsp");
		return "index";
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(HttpServletRequest req) {
		dao.sumsearch(req);
		// dao.winningRate(req);
		dao.matchl(req);
		dao.ingamenow(req);

		req.setAttribute("contentPage", "output.jsp");
		req.setAttribute("summonerPage", "match.jsp");

		return "index";
	}

	@RequestMapping(value = "matchsearch", method = RequestMethod.GET)
	public String matchsearch(HttpServletRequest req) {
		dao.sumsearch(req);
		dao.winningRate(req);
		dao.matchl(req);
		dao.matchlsearch(req);
		dao.ingamenow(req);

		req.setAttribute("contentPage", "output.jsp");
		req.setAttribute("summonerPage", "match.jsp");

		return "index";
	}

	@RequestMapping(value = "matchdetail", method = RequestMethod.GET)
	public String matchdetail(HttpServletRequest req) {
		dao.sumsearch(req);
		dao.gamedata(req);
		dao.ingamenow(req);
		req.setAttribute("contentPage", "output.jsp");
		req.setAttribute("summonerPage", "matchDetail.jsp");
		return "index";
	}

	@RequestMapping(value = "ingame", method = RequestMethod.GET)
	public String ingame(HttpServletRequest req) {
		dao.sumsearch(req);
		dao.ingame(req);

		req.setAttribute("contentPage", "output.jsp");
		req.setAttribute("summonerPage", "ingame.jsp");
		return "index";
	}

	@RequestMapping(value = "killtimeline", method = RequestMethod.GET)
	public String killtime(HttpServletRequest req) {
		dao.sumsearch(req);
		tdao.timeline(req);
		dao.ingamenow(req);

		req.setAttribute("contentPage", "output.jsp");
		req.setAttribute("summonerPage", "matchTimeline.jsp");
		return "index";
	}

	@RequestMapping(value = "chal", method = RequestMethod.GET)
	public String chell(challchampick cp, challchampban cb, HttpServletRequest req) {
		// rdao.banpicks(cb, cp, req);
		req.setAttribute("contentPage", "rate/rateMain.jsp");
		// req.setAttribute("summonerPage", "rateResult.jsp");

		return "index";
	}

	@RequestMapping(value = "challlist", method = RequestMethod.GET)
	public String chelllistupdate(challlist c, HttpServletRequest req) {
		rdao.challsave(c, req);
		req.setAttribute("contentPage", "rate/rateMain.jsp");
		req.setAttribute("summonerPage", "nore.jsp");
		return "index";
	}
<<<<<<< HEAD
//	@RequestMapping(value = "challlist", method = RequestMethod.GET)
//	public String chelllistupdate(challlist c, HttpServletRequest req) {
//		rdao.challsave(c, req);
//		
//		return "rate/testpage";
//	}
	

=======
>>>>>>> branch 'main' of https://github.com/developer-sora/sora.gg.majimak.git

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login(HttpServletRequest req) {
		req.setAttribute("contentPage", "login/login.jsp");
		return "index";
	}

	@RequestMapping(value = "loginsuccess", method = RequestMethod.POST)
	public String loginSuccess(HttpServletRequest req) {
		req.setAttribute("contentPage", "login/loginsuccess.jsp");
		return "index";
	}

	@RequestMapping(value = "login.go", method = RequestMethod.POST)
	public String loginGo(userID u, HttpServletRequest req) {
		ldao.login(u, req);
		req.setAttribute("contentPage", "search.jsp");
		return "index";
	}

	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req, HttpServletResponse res) {
		ldao.logout(req, res);
		req.setAttribute("contentPage", "search.jsp");
		return "index";
	}

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join(HttpServletRequest req) {

		req.setAttribute("contentPage", "login/join.jsp");
		return "index";
	}
<<<<<<< HEAD
	
=======

>>>>>>> branch 'main' of https://github.com/developer-sora/sora.gg.majimak.git
	@RequestMapping(value = "join.go", method = RequestMethod.POST)
	public String joinGo(userID u, HttpServletRequest req) {
		ldao.join(u, req);
		req.setAttribute("contentPage", "login/login.jsp");
		return "index";
	}

<<<<<<< HEAD
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
//		  String pictureUrl = (String) payload.get("picture");
//		  String locale = (String) payload.get("locale");
//		  String familyName = (String) payload.get("family_name");
//		  String givenName = (String) payload.get("given_name");

		  
		  System.out.println(email);
		  
		  
		  // Use or store profile information
		  // ...
		  
		} else {
		  System.out.println("Invalid ID token.");
		}
			}catch (Exception e) {
				e.printStackTrace();
			}
		return "";
	}	
=======
//	@RequestMapping(value = "loginsuccess", method = RequestMethod.POST)
//	public String callback(HttpServletRequest req) throws GeneralSecurityException, IOException {
//			try {
//				
//			
//			NetHttpTransport transport = new NetHttpTransport();
//			JacksonFactory jsonFactory = new JacksonFactory();
//			
//		GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
//	    // Specify the CLIENT_ID of the app that accesses the backend:
//		    .setAudience(Collections.singletonList("696606451912-1qpdbt2mgtl7lpnqn67pmrv3v5k2ocri.apps.googleusercontent.com"))/		    // Or, if multiple clients access the backend:
//		    //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
//		    .build();
//
//		// (Receive idTokenString by HTTPS POST)
//
//		String idTokenString = req.getParameter("idtoken");
//		GoogleIdToken idToken = verifier.verify(idTokenString);
//		
//		if (idToken != null) {
//		  Payload payload = idToken.getPayload();
//
//		  // Print user identifier
//		  String userId = payload.getSubject();
//		  System.out.println("User ID: " + userId);
//
//		  // Get profile information from payload
//		  String email = payload.getEmail();
//		  boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
//		  String name = (String) payload.get("name");
////		  String pictureUrl = (String) payload.get("picture");
////		  String locale = (String) payload.get("locale");
////		  String familyName = (String) payload.get("family_name");
////		  String givenName = (String) payload.get("given_name");
//
//		  
//		  System.out.println(email);
//		  
//		  
//		  // Use or store profile information
//		  // ...
//		  
//		} else {
//		  System.out.println("Invalid ID token.");
//		}
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		return "";
>>>>>>> branch 'main' of https://github.com/developer-sora/sora.gg.majimak.git
	@RequestMapping(value = "challgamereg", method = RequestMethod.GET)
	public String chellgamereg(challlist c, GameId g, HttpServletRequest req) {
		rdao.getchallmatchlist(c, g);
		req.setAttribute("contentPage", "rate/rateMain.jsp");
		req.setAttribute("summonerPage", "nore.jsp");
		return "index";
	}

	@RequestMapping(value = "champreg", method = RequestMethod.GET)
	public String champ(challchampick cp, challchampban cb, GameId g, HttpServletRequest req) {
		rdao.champreg(cb, cp, g);
		req.setAttribute("regr", "챔프등록됨");
<<<<<<< HEAD
		return "rate/testpage";
	}
	
	@RequestMapping(value = "community", method = RequestMethod.GET)
	public String community( HttpServletRequest req) {
		
		req.setAttribute("contentPage", "community/duo.jsp");
=======
		req.setAttribute("contentPage", "rate/rateMain.jsp");
		req.setAttribute("summonerPage", "nore.jsp");
>>>>>>> branch 'main' of https://github.com/developer-sora/sora.gg.majimak.git
		return "index";
	}

	@RequestMapping(value = "champresult", method = RequestMethod.GET)
	public String champre(challchampick cp, challchampban cb, HttpServletRequest req) {
		dao.apiver(req);
		rdao.banpicks(cb, cp, req);
		req.setAttribute("contentPage", "rate/rateMain.jsp");
		req.setAttribute("summonerPage", "rateResult.jsp");
		return "index";
	}

	@RequestMapping(value = "champion", method = RequestMethod.GET)
	public String allChampion(HttpServletRequest req) {

		dao.allChampion(req);

		req.setAttribute("contentPage", "championSearch.jsp");
		req.setAttribute("championPage", "allChampion.jsp");
		return "index";
	}

	@RequestMapping(value = "rotation", method = RequestMethod.GET)
	public String rotationChampion(HttpServletRequest req) {

		dao.rotationChampion(req);

		req.setAttribute("contentPage", "championSearch.jsp");
		req.setAttribute("championPage", "rotation.jsp");
		return "index";
	}

	@RequestMapping(value = "champDetail", method = RequestMethod.GET)
	public String champDetail(tip t, HttpServletRequest req) {

		dao.championPassive(req);
		dao.championskill(req);

		req.setAttribute("contentPage", "champDetail.jsp");
		req.setAttribute("tipPage", "champTip.jsp");
		return "index";
	}

	@RequestMapping(value = "championSearch", method = RequestMethod.GET)
	public String championSearch(HttpServletRequest req) {

		dao.championSearch(req);

		req.setAttribute("contentPage", "championSearch.jsp");
		req.setAttribute("championPage", "allChampion.jsp");
		return "index";
	}

	@RequestMapping(value = "regTip", method = RequestMethod.GET)
	public String regTip(HttpServletRequest req) {

		
		
		req.setAttribute("tipPage", "champTip.jsp");
		return "index";
	}
}
