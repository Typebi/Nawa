package re_attr.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Attr;
import domain.Reply;
import domain.Review;
import re_attr.model.ReviewService;
import re_attr.vo.ListResult;
import userManagement.domain.Member;

@WebServlet("/re_attr/re_attr.do")
public class ReviewController extends HttpServlet{
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
			}else if(m.equals("go")) {
				go(request, response);
			}else if(m.equals("back")) {
				back(request, response);
			}else if (m.equals("insert")) {
				insert(request, response);
			}else if(m.equals("del")) {
				del(request, response);
			}else if(m.equals("recommend")) {
				recommend(request, response);
			}else if(m.equals("comment")) {
				comment(request, response);
			}else if (m.equals("content")) {
				content(request, response);
			}else if (m.equals("update")) {
				update(request, response);
			}else if (m.equals("comm_del")) {
				comm_del(request, response);
			}
		} else {
			list(request, response);
		}
	}
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String attr_seqStr = request.getParameter("attr_seq");
		int attr_seq = 0;
		if(attr_seqStr != null) {
			attr_seq = Integer.parseInt(attr_seqStr);
		}
		
		HttpSession session= request.getSession();
		session.setAttribute("attr_seq",attr_seq);
		String cpStr = request.getParameter("cp");
		
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
		ReviewService service = ReviewService.getInstance();
		ListResult listResult = service.getListResult(cp, cpp,attr_seq);
		request.setAttribute("listResult",listResult);
		Attr attr = service.getAttr(attr_seq);
		request.setAttribute("attr", attr);
		request.setAttribute("reviewList",listResult.getList());
		if(listResult.getList().size() ==0) {
		if(cp>1) {
			response.sendRedirect("re_attr.do?m=list&cp="+(cp-1));
		}else {
			request.setAttribute("listResult", null);
			String view = "../sub/re_attr.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request,response);
		}
		}else {
		String view = "../sub/re_attr.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
	
		rd.forward(request, response);
		}
		
	}
	private void go(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String attr_seqStr = request.getParameter("attr_seq");
		int attr_seq = Integer.parseInt(attr_seqStr);
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

		ReviewService service = ReviewService.getInstance();
		ListResult listResult =service.getListResult(cp,cpp,attr_seq);
		if(cp<listResult.getTotalPageCount()) { 
			session.setAttribute("cp", cp+1);
			listResult =service.getListResult(cp+1,cpp,attr_seq);
		}else if(cp==listResult.getTotalPageCount()) {
			listResult =service.getListResult(cp,cpp,attr_seq);
			session.setAttribute("cp", cp);		
		}
		request.setAttribute("listResult",listResult);
		if(listResult.getList().size() ==0) {
				request.setAttribute("listResult", null);
				String view = "../sub/re_attr.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request,response);
		}else {
			String view ="../sub/re_attr.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request,response);
		}
	}
	private void back(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException{
		String attr_seqStr = request.getParameter("attr_seq");
		int attr_seq = Integer.parseInt(attr_seqStr);
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
		
		ReviewService service = ReviewService.getInstance();
		ListResult listResult =null;
		
		if (cp!=1) {
			session.setAttribute("cp", cp-1);
			listResult =service.getListResult(cp-1,cpp,attr_seq);
		}else {
			session.setAttribute("cp", cp);
			listResult =service.getListResult(cp,cpp,attr_seq);
		}
		request.setAttribute("listResult",listResult);
		if(listResult.getList().size() ==0) {
				request.setAttribute("listResult", null);
				String view = "../sub/re_attr.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request,response);
		}else {
			String view ="../sub/re_attr.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request,response);
		}
	}
	private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String review_subject = request.getParameter("review_subject");
		String review_content = request.getParameter("review_content");
		HttpSession session= request.getSession();
		int attr_seq = (int)session.getAttribute("attr_seq");
		String email = request.getParameter("email");
		
		String rateStr = request.getParameter("rate");
		int rate = Integer.parseInt(rateStr);
		ReviewService service = ReviewService.getInstance();
		service.insertS(new Review(-1,attr_seq,email,review_subject,review_content,rate,0,null));
		
		String view = "../re_attr/re_attr.do?m=list&attr_seq="+attr_seq;
		response.sendRedirect(view);
	}
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String seqStr = request.getParameter("re_seq");
		String attr_seqStr = request.getParameter("attr_seq");
		int re_seq = 0;
		int attr_seq=0;
		if (seqStr == null) {
		} else {
			seqStr = seqStr.trim();
			try {
				re_seq = Integer.parseInt(seqStr);
				ReviewService service = ReviewService.getInstance();
				boolean flag = service.delS(re_seq);
				request.setAttribute("flag", flag);
			} catch (NumberFormatException ne) {
			}
		}
		if(attr_seqStr ==null) {
		}else {
			attr_seqStr = attr_seqStr.trim();
			try {
				attr_seq = Integer.parseInt(attr_seqStr);
			}catch (NumberFormatException ne) {
			}
		}

		String view = "../re_attr/re_attr.do?m=list&attr_seq="+attr_seq;
		response.sendRedirect(view);
	}
	private void recommend(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String seqStr = request.getParameter("re_seq");
		String attr_seqStr = request.getParameter("attr_seq");
		int re_seq = 0;
		int attr_seq=0;
		if (seqStr == null) {
		} else {
			seqStr = seqStr.trim();
			try {
				re_seq = Integer.parseInt(seqStr);
				ReviewService service = ReviewService.getInstance();
		        service.recommend(new Review(re_seq));
				

			} catch (NumberFormatException ne) {
			}
		}
		if(attr_seqStr ==null) {
		}else {
			attr_seqStr = attr_seqStr.trim();
			try {
				attr_seq = Integer.parseInt(attr_seqStr);
			}catch (NumberFormatException ne) {
			}
		}

		String view = "../re_attr/re_attr.do?m=list&attr_seq="+attr_seq;
		response.sendRedirect(view);
			
	}
	private void comment(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String re_seqStr = request.getParameter("re_seq");
		String attr_seqStr = request.getParameter("attr_seq");
		String comm_content = request.getParameter("comm_content");
		String email = request.getParameter("email");
		int re_seq = 0;
		int attr_seq=0;
		if(attr_seqStr ==null) {
		}else {
			attr_seqStr = attr_seqStr.trim();
			try {
				attr_seq = Integer.parseInt(attr_seqStr);
			}catch (NumberFormatException ne) {
			}
		}
		if(re_seqStr ==null) {
		}else {
			re_seqStr = re_seqStr.trim();
			try {
				re_seq = Integer.parseInt(re_seqStr);
			}catch (NumberFormatException ne) {
			}
		}
		ReviewService service = ReviewService.getInstance();
		service.insertC(new Reply(-1,comm_content,null,re_seq,email));
		String view = "../re_attr/re_attr.do?m=list&attr_seq="+attr_seq;
		response.sendRedirect(view);
	}
	private void content(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String re_seqStr = request.getParameter("re_seq");
		int re_seq = 0;
		if (re_seqStr == null) {
		} else {
			re_seqStr = re_seqStr.trim();
			try {
				re_seq = Integer.parseInt(re_seqStr);
				ReviewService service = ReviewService.getInstance();
				ArrayList<Review> content = service.contentS(re_seq);
				request.setAttribute("content", content);
			} catch (NumberFormatException ne) {
			}
		}
		String view = "../sub/re_update.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String re_seqStr = request.getParameter("re_seq");
		String review_subject = request.getParameter("review_subject");
		String rateStr = request.getParameter("rate");
		String review_content = request.getParameter("review_content");
		HttpSession session= request.getSession();
		int attr_seq = (int)session.getAttribute("attr_seq");
		int re_seq=0;
		int rate = 1;
		re_seq = Integer.parseInt(re_seqStr);
		rate = Integer.parseInt(rateStr);
		ReviewService service = ReviewService.getInstance();
		boolean update = service.updateS(re_seq, review_subject, rate, review_content);
		request.setAttribute("update", update);
		String view = "../re_attr/re_attr.do?m=list&attr_seq="+attr_seq;
		response.sendRedirect(view);
	}
	private void comm_del(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String re_seqStr = request.getParameter("re_seq");
		String comm_seqStr = request.getParameter("comm_seq");
		String attr_seqStr = request.getParameter("attr_seq");
		int re_seq = 0;
		int comm_seq = 0;
		int attr_seq = 0;
		comm_seqStr = comm_seqStr.trim();
		re_seqStr = re_seqStr.trim();
		try {
			attr_seq = Integer.parseInt(attr_seqStr);
			comm_seq = Integer.parseInt(comm_seqStr);
			re_seq = Integer.parseInt(re_seqStr);
			ReviewService service = ReviewService.getInstance();
	       
			boolean flag = service.delC(re_seq,comm_seq);
			request.setAttribute("flag", flag);

		} catch (NumberFormatException ne) {
		}
	

		String view = "../re_attr/re_attr.do?m=list&attr_seq="+attr_seq;
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
