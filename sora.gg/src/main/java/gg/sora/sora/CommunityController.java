package gg.sora.sora;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gg.sora.community.CMsg;
import gg.sora.community.CommunityDAO;
import gg.sora.dto.CSearch;

@Controller
public class CommunityController {
	
	@Autowired
	private CommunityDAO cdao;
	
	@RequestMapping(value = "community", method = RequestMethod.GET)
	public String community(CMsg m, HttpServletRequest req) {
		cdao.getAllMsg(m,req);
		TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "community/duo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "write", method = RequestMethod.GET)
	public String write( HttpServletRequest req) {
		TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "community/write.jsp");
		return "index";
	}
	
	@RequestMapping(value = "write.do", method = RequestMethod.GET)
	public String writeDo(CMsg m,HttpServletRequest req) {
		
		cdao.write(m, req);
		cdao.getAllMsg(m,req);
		TokenMaker.makeToken(req);
		req.setAttribute("contentPage", "community/duo.jsp");
		return "index";
	}
	
	@RequestMapping(value = "c.del", method = RequestMethod.GET)
	public String del(CMsg m,HttpServletRequest req) {
		cdao.del(m, req);
		cdao.getAllMsg(m,req);
		req.setAttribute("contentPage", "community/duo.jsp");
		return "index";
	}
	
	
	
	@RequestMapping(value = "duo.search.go", method = RequestMethod.GET)
	public String duoSearch(CSearch cs,CMsg m,HttpServletRequest req) {
//		cdao.searchMsg(req);
		cdao.getMsg(cs,req);
//		cdao.del(m, req);
		req.setAttribute("contentPage", "community/duo.jsp");
		return "index";
	}
	
	
}
