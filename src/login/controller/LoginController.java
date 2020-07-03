package login.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import login.model.LoginService;
import record.log.Logger;
import userManagement.domain.*;
import userManagement.exceptions.*;

@WebServlet("/login/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");
		Logger logger = Logger.getInstance();
		logger.getLogFile();
		logger.recordLog((null != request.getHeader("X-FORWARDED-FOR")) ? request.getHeader("X-FORWARDED-FOR")+" "+code : request.getRemoteAddr()+" "+code, Logger.LOG_INFO);
		if (code != null) {
			code = code.trim();
			if (code.equals("login")) {
				login(request, response);
			} else if (code.equals("kakaoLogin")) {
				kakaoLogin(request, response);
			} else if (code.equals("logout")) {
				logOut(request, response);
			}
		} else {
			loginForm(request, response);
		}
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginService service = LoginService.getInstance();
		try {
			Email e = new Email(request.getParameter("email"));
			Pwd p = new Pwd(request.getParameter("pwd"));
			Member m = service.isMember(e,p);
			request.getSession().setAttribute("user", m);
			response.sendRedirect("login_msg.jsp");
			return;
		}catch(EmailException e) { System.out.println("Exception : "+e); request.setAttribute("LoginError", 1);
		}catch(PwdException e) { System.out.println("Exception : "+e); request.setAttribute("LoginError", 2);
		}
		this.getServletContext().getRequestDispatcher("/login/login_msg.jsp").forward(request, response);
	}
	private void kakaoLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("deprecation")
		JsonObject json = new JsonParser().parse(request.getParameter("kakao")).getAsJsonObject();
		String kakaoNick  = json.getAsJsonObject("properties").get("nickname").toString();
		//카카오계정 정보는 DB에 저장 하지 않을 예정.
		request.getSession().setAttribute("kakaoUser", kakaoNick);
		response.sendRedirect("../");
	}
	private void loginForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      response.sendRedirect("login.jsp");
   }
   private void logOut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession();
      session.invalidate();
      response.sendRedirect("../");
   }
}