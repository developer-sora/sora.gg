package gg.sora.sora;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {
	String path = "/error";

	@RequestMapping(value = "/error")
	public String error() {
		return "errorPage";
	}
	@RequestMapping(value = "/404error")
	public String error404(HttpServletRequest req) {
		req.setAttribute("errormsg", "잘못된 페이지로 접근하신 것 같아요! 홈으로 돌아가 정상적인 경로를 이용해주세요");
		return "errorPage";
	}
	@RequestMapping(value = "/500error")
	public String error500(HttpServletRequest req) {
	req.setAttribute("errormsg", "저희 서비스에 이상이 있는 것 같습니다. 죄송하지만 홈으로 돌아가 다시 이용해주세요");
		return "errorPage";
	}

}
