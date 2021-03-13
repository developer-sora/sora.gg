package gg.sora.sora;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gg.sora.dao.championDAO;
import gg.sora.dto.tip;

@Controller
public class ChampionController {

	@Autowired
	championDAO cDAO;

	@RequestMapping(value = "champion", method = RequestMethod.GET)
	public String allChampion(HttpServletRequest req) {

		cDAO.allChampion(req);

		req.setAttribute("contentPage", "championSearch.jsp");
		req.setAttribute("championPage", "allChampion.jsp");
		return "index";
	}

	@RequestMapping(value = "rotation", method = RequestMethod.GET)
	public String rotationChampion(HttpServletRequest req) {

		cDAO.rotationChampion(req);

		req.setAttribute("contentPage", "championSearch.jsp");
		req.setAttribute("championPage", "rotation.jsp");
		return "index";
	}

	@RequestMapping(value = "champDetail", method = RequestMethod.GET)
	public String champDetail(HttpServletRequest req) {

		cDAO.championPassive(req);
		cDAO.championskill(req);

		req.setAttribute("contentPage", "champDetail.jsp");
		req.setAttribute("tipPage", "champTip.jsp");
		return "index";
	}

	@RequestMapping(value = "championSearch", method = RequestMethod.GET)
	public String championSearch(HttpServletRequest req) {

		cDAO.championSearch(req);

		req.setAttribute("contentPage", "championSearch.jsp");
		req.setAttribute("championPage", "allChampion.jsp");
		return "index";
	}

	@RequestMapping(value = "regTip", method = RequestMethod.GET)
	public String regTip(tip t, HttpServletRequest req) {

		cDAO.getAllTip(t, req);

		req.setAttribute("tipPage", "champTip.jsp");
		return "index";
	}

}
