package member.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import domain.Member;
import member.model.MemberService;


@WebServlet("/mypage/mypage.do")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String m="";

	public void service(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		m=request.getParameter("m");
		if(m.equals("mypage")) {
			mypage(request,response);
		}else if(m.equals("update")) {
			update(request,response);
		}else if(m.equals("delete")) {
			delete(request,response);
		}
	}

	
	private void mypage(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		MemberService service = MemberService.getInstance();
		HttpSession session =request.getSession();
		userManagement.domain.Member member1 = (userManagement.domain.Member)session.getAttribute("user");
		String email=member1.getEmail();
		//System.out.println("email:"+ member.getEmail());
		Member member = service.mypageS(email);
		System.out.println("email:"+member.getEmail());

		//String user = (String)session.getAttribute("user");
		session.setAttribute("user", member1);
		String view="mypage.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request,response);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String email=request.getParameter("email");
		String pwd = request.getParameter("pwd");
		String nick_name=request.getParameter("user_name");

		MemberService service = MemberService.getInstance();
		service.updateS(new Member(email,pwd,nick_name,0,null));
			System.out.println("ddfd");
		response.sendRedirect("../index.do");
	}
	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String email=request.getParameter("email");
			
			MemberService service = MemberService.getInstance();
			service.deleteS(email);
		
			
			response.sendRedirect("../index.do");
		}

}
