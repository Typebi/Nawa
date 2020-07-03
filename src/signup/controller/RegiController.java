package signup.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.MalformedJsonException;

import signup.model.RegiService;
import userManagement.domain.*;
import userManagement.exceptions.*;

@WebServlet("/signup/signup")
public class RegiController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
	   	String code = request.getParameter("code");
	   	if(code != null) {
	   		code = code.trim();
	   		if(code.equals("signup")) {
	   			response.sendRedirect("regi_form.jsp");
	   		}else if(code.equals("register")) {
	   			register(request, response);
	   		}else if(code.equals("ajax")) {
	   			ajaxEmail(request, response);
	   		}
	   	}else {
	   		returnForm(request, response);
	   	}
	}
   
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegiService service = RegiService.getInstance();
		HttpSession session = request.getSession();
		try {
			Email e = new Email(request.getParameter("email").toLowerCase().trim()+"@"+request.getParameter("host").toLowerCase().trim());
			Pwd p = new Pwd(request.getParameter("pwd").toLowerCase().trim(), request.getParameter("pwd2").toLowerCase().trim());
			Nick n = new Nick(request.getParameter("nick").trim());
			if(!service.isMember(e))
				if(service.insertMember(e,p,n)!=1) throw new EmailException("정의되지 않은 오류. Insert 실패.");
				else System.out.println("인서트 성공");
			else {
				throw new EmailException("이미 가입된 이메일입니다.");
			}
			request.setAttribute("errorName", 0);
			session.setAttribute("user", service.getMember(e));
		}catch(EmailException e) { System.out.println("Exception : "+e); request.setAttribute("errorName", 1);
		}catch(PwdException e) { System.out.println("Exception : "+e); request.setAttribute("errorName", 2);
		}catch(NickException e) { System.out.println("Exception : "+e); request.setAttribute("errorName", 3);
		}
		this.getServletContext().getRequestDispatcher("/signup/signup_msg.jsp").forward(request, response);
	}
	private void returnForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("user");
	    session.removeAttribute("kakaoUser");
		response.sendRedirect("signup.jsp");
	}
	
	@SuppressWarnings("deprecation")
	private void ajaxEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RegiService service = RegiService.getInstance();
		try {
			JsonObject json = new JsonObject();
			json.addProperty("isExist", "0");
			if(service.isMember(new Email(new JsonParser().parse(request.getParameter("email")).getAsString()))) {
				json.addProperty("isExist", "1");
				response.getWriter().print(new Gson().toJson(json));
			}else response.getWriter().print(new Gson().toJson(json));
		}catch(EmailException e) {
		}catch(MalformedJsonException e) {}
	}
}