package attr.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import attr.model.AttrService;
import attr.vo.ListResult;
import domain.Attr;


@WebServlet("/attr/attr.do")
public class AttrController  extends HttpServlet{
	private static final long serialVersionUID = 1L;
	int cpp=5;
	private String m = "";
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		m = request.getParameter("m");
		if (m != null) {
			m = m.trim();
			if (m.equals("list")) {
				list(request, response);
			}else if (m.equals("insert")) {
				insert(request, response);
			}else if(m.equals("del")) {
				del(request, response);
			}else if(m.equals("go")) {
				go(request, response);
			}else if(m.equals("back")) {
				back(request, response);
			}else if(m.equals("search")) {
				search(request, response);
			}
		} else {
			list(request, response);
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		String cpStr = request.getParameter("cp");
		HttpSession session= request.getSession();
		int cp=1;
		if(cpStr == null) {
			Object cpObj=session.getAttribute("cp");
			if(cpObj != null) {
				cp=(Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp=Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		String area_noStr = request.getParameter("area_no");
		if(area_noStr != null) {
			int area_no = Integer.parseInt(area_noStr);
			AttrService service = AttrService.getInstance();
			ArrayList<Attr> list =service.listS(area_no);
			request.setAttribute("list", list);
			if(area_no == 23) {
				String view = "../sub/23_jongro.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				
				rd.forward(request, response);
			}else if(area_no == 14) {
				String view = "../sub/14_seodaemun.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				
				rd.forward(request, response);
			}
		}else {
			AttrService service = AttrService.getInstance();
			ListResult listResult = service.getListResult(cp, cpp);
			request.setAttribute("listResult",listResult);
			if(listResult.getListA().size() ==0) {
				if(cp>1) {
					response.sendRedirect("attr.do?m=list&cp="+(cp-1));
				}else {
					request.setAttribute("listResult", null);
					String view = "../sub/review.jsp";
					RequestDispatcher rd = request.getRequestDispatcher(view);
					rd.forward(request,response);
				}
			}else {
			String view = "../sub/review.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
		
			rd.forward(request, response);
			}
		}
		
		
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String attr_name = request.getParameter("attr_name");
		String attr_addr = request.getParameter("attr_addr");
		String attr_info = request.getParameter("attr_info");
		String area_noStr = request.getParameter("area_no");
		int area_no = Integer.parseInt(area_noStr);
		String email = "admin";
		AttrService service = AttrService.getInstance();
		service.insertS(new Attr(-1,email,attr_name,attr_addr,attr_info,0,area_no));
		
		String view = "attr.do";
		response.sendRedirect(view);
	}
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seqStr = request.getParameter("attr_seq");
		int attr_seq = 0;
		if (seqStr == null) {
		} else {
			seqStr = seqStr.trim();
			try {
				attr_seq = Integer.parseInt(seqStr);
				AttrService service = AttrService.getInstance();
		       
				boolean flag = service.delS(attr_seq);
				request.setAttribute("flag", flag);

			} catch (NumberFormatException ne) {
			}
		}

		String view = "../attr/attr.do?m=list";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void go(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String cpStr = request.getParameter("cp");
		int cp=1;
		HttpSession session= request.getSession();
		if(cpStr ==null) {
			Object cpObj=session.getAttribute("cp");
			if(cpObj != null) {
				cp=(Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp=Integer.parseInt(cpStr);
		}

		AttrService service = AttrService.getInstance();
		ListResult listResult =service.getListResult(cp,cpp);
		if(cp<listResult.getTotalPageCount()) { 
			session.setAttribute("cp", cp+1);
			listResult =service.getListResult(cp+1,cpp);
		}else if(cp==listResult.getTotalPageCount()) {
			listResult =service.getListResult(cp,cpp);
			session.setAttribute("cp", cp);		
		}
		request.setAttribute("listResult",listResult);
		if(listResult.getListA().size() ==0) {
				request.setAttribute("listResult", null);
				String view = "../sub/review.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request,response);
		}else {
			String view ="../sub/review.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request,response);
		}
	}
	private void back(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		String cpStr = request.getParameter("cp");
		int cp=1;
		HttpSession session= request.getSession();
		if(cpStr ==null) {
			Object cpObj=session.getAttribute("cp");
			if(cpObj != null) {
				cp=(Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp=Integer.parseInt(cpStr);
		}
		
		AttrService service = AttrService.getInstance();
		ListResult listResult =null;
		
		if (cp!=1) {
			session.setAttribute("cp", cp-1);
			listResult =service.getListResult(cp-1,cpp);
		}else {
			session.setAttribute("cp", cp);
			listResult =service.getListResult(cp,cpp);
		}
		request.setAttribute("listResult",listResult);
		if(listResult.getListA().size() ==0) {
				request.setAttribute("listResult", null);
				String view = "../sub/review.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request,response);
		}else {
			String view ="../sub/review.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request,response);
		}
	}
	private void search(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpStr = request.getParameter("cp");//현재페이지
		HttpSession session= request.getSession();
		int cp=1;
		if(cpStr ==null) {
			Object cpObj=session.getAttribute("cp");
			if(cpObj != null) {
				cp=(Integer)cpObj;
			}
		}else {
			cpStr = cpStr.trim();
			cp=Integer.parseInt(cpStr);
		}
		session.setAttribute("cp", cp);
		String attr_name = request.getParameter("attr_name");
		attr_name=attr_name.trim();
		AttrService service = AttrService.getInstance();
		ListResult listResult=service.getSearchResult(cp, cpp,attr_name);
		
		request.setAttribute("listResult",listResult);
		
		if(listResult.getListA().size() ==0) {
			if(cp>1) {
				response.sendRedirect("attr.do?m=list&cp="+(cp-1));
			}else {
				request.setAttribute("listResult", null);
				String view = "../sub/review.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request,response);
			}
		}else {
			String view ="../sub/review.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request,response);
		}
	}
}
