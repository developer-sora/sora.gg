package gg.sora.sora;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gg.sora.dao.DAO;
import gg.sora.dao.timelineDAO;

@Controller
public class HomeController {
	
	@Autowired
	private DAO dao;
	@Autowired
	private timelineDAO tdao;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest req) {
		req.setAttribute("contentPage", "search.jsp");
		return "index";
	}

	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String search(HttpServletRequest req) {
			dao.sumsearch(req);
		//	dao.winningRate(req);
			dao.matchl(req);
			dao.ingamenow(req);
			
			req.setAttribute("contentPage", "output.jsp");
			req.setAttribute("summonerPage", "match.jsp");

		return "index";
	}
	@RequestMapping(value = "matchsearch", method = RequestMethod.GET)
	public String matchsearch(HttpServletRequest req) {
		dao.sumsearch(req);
		//	dao.winningRate(req);
	//	dao.matchl(req);
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

}
