package community.control;

import java.io.*;
//import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.oreilly.servlet.multipart.FileRenamePolicy;

import community.model.CommuService;
// import community.model.FileSet;
import community.vo.ListResult;
import domain.Community;

/**
 * Servlet implementation class CommuController
 */
@WebServlet("/Commu/Commu.do")
public class CommuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int cpp = 10;   
	private String m = "";
    public void service(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
		m = request.getParameter("m");
		if(m != null) {
			m = m.trim();
			if(m.equals("list")) {
				list(request, response);
			}else if(m.equals("search")) {
				search(request, response);
			}else if(m.equals("go")) {
				go(request, response);
			}else if(m.equals("back")) {
				back(request, response);
			}else if(m.equals("write")) {
				write(request, response);
			}else if(m.equals("insert")) {
				insert(request, response);
			}else if(m.equals("content")) {
				getBoard(request, response);
			}else if(m.equals("update")) {
				getBoard(request, response);
			}else if(m.equals("updateOk")) {
				updateOk(request, response);
			}else if(m.equals("download")) {
				download(request, response);
			}else if(m.equals("del")){
				del(request, response);
			}else {
				list(request, response);
			}
		}else {
			list(request, response);
		}		
	}

    /*private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	
    	CommuService service = CommuService.getInstance();
    	ArrayList<Community> list = service.listS();
    	request.setAttribute("list" , list);

    	String view = "../sub/2_1.jsp";
    	RequestDispatcher rd = request.getRequestDispatcher(view);
    	rd.forward(request, response);
    }*/
    private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	String cpStr = request.getParameter("cp");
    	HttpSession session = request.getSession();
    	
    	int cp = 1;
    	if(cpStr == null) {

    		Object cpObj = session.getAttribute("cp");
    		if(cpObj != null) {
    			cp = (Integer)cpObj;
    		}
    	}else {
    		cpStr = cpStr.trim();
    		cp = Integer.parseInt(cpStr);
    	}
    	session.setAttribute("cp", cp);

    	CommuService service = CommuService.getInstance();
    	ListResult listResult = service.getListResult(cp, cpp);
    	request.setAttribute("listResult", listResult);
    	
    	if(listResult.getList().size() == 0) {
    		if(cp>1) {
    			response.sendRedirect("commu.do?m=list&cp="+(cp-1));
    		}else {
    			request.setAttribute("listResult", null);
    			String view = "list.jsp";
    			RequestDispatcher rd = request.getRequestDispatcher(view);
    			rd.forward(request, response);
    		}
    	}else {
    		
    		String view = "../sub/2_1.jsp";
        	RequestDispatcher rd = request.getRequestDispatcher(view);
        	rd.forward(request, response);
    	}
    }
    private void search(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	String cpStr = request.getParameter("cp");
    	HttpSession session = request.getSession();
    	
    	int cp = 1;
    	if(cpStr == null) {
    		Object cpObj = session.getAttribute("cp");
    		if(cpObj != null) {
    			cp = (Integer)cpObj;
    		}
    	}else {
    		cpStr = cpStr.trim();
    		cp = Integer.parseInt(cpStr);
    	}
    	session.setAttribute("cp", cp);
    	String subject = request.getParameter("subject");
    	subject = subject.trim();
    	CommuService service = CommuService.getInstance();
    	ListResult listResult = service.getSearchResult(cp, cpp, subject);
    	request.setAttribute("listResult",listResult);
    	if(listResult.getList().size() ==0) {
			if(cp>1) {
				response.sendRedirect("board.do?m=list&cp="+(cp-1));
			}else {
				request.setAttribute("listResult", null);
				String view = "../sub/2_1.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request,response);
			}
		}else {
			String view ="../sub/2_1.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request,response);
		}
    }
    
    private void go(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException{
    	String cpStr = request.getParameter("cp");
    	HttpSession session = request.getSession();
    	
    	int cp = 1;
    	if(cpStr == null) {   		
    		Object cpObj = session.getAttribute("cp");
    		if(cpObj != null) {
    			cp = (Integer)cpObj;
    		}
    	}else {
    		cpStr = cpStr.trim();
    		cp = Integer.parseInt(cpStr);
    	}
    	
    	CommuService service = CommuService.getInstance();
    	ListResult listResult = service.getListResult(cp, cpp);
    	if(cp < listResult.getTotalPageCount()) {
    		session.setAttribute("cp", cp+1);
    		listResult = service.getListResult(cp+1, cpp);
    	}else if(cp == listResult.getTotalPageCount()) {
    		listResult = service.getListResult(cp, cpp);
    		session.setAttribute("cp", cp);	
    	}
    	request.setAttribute("listResult",listResult);
    	if(listResult.getList().size() == 0) {
    		request.setAttribute("listResult", null);
    		String view = "../sub/2_1.jsp";
        	RequestDispatcher rd = request.getRequestDispatcher(view);
        	rd.forward(request, response);
    	}else {
    		String view = "../sub/2_1.jsp";
        	RequestDispatcher rd = request.getRequestDispatcher(view);
        	rd.forward(request, response);
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
		
		CommuService service = CommuService.getInstance();
		ListResult listResult =null;
		
		if (cp!=1) {
			session.setAttribute("cp", cp-1);
			listResult =service.getListResult(cp-1,cpp);
		}else {
			session.setAttribute("cp", cp);
			listResult =service.getListResult(cp,cpp);
		}
		request.setAttribute("listResult",listResult);
		if(listResult.getList().size() ==0) {
				request.setAttribute("listResult", null);
				String view = "../sub/2_1.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request,response);
		}else {
			String view = "../sub/2_1.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(view);
			rd.forward(request,response);
		}
	}
    /*private void search(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	String cpStr = request.getParameter("cp");
    	HttpSession session = request.getSession();
    	
    	int cp = 1;
    	if(cpStr == null) {
    		Object cpObj = session.getAttribute("cp");
    		if(cpObj != null) {
    			cp = (Integer)cpObj;
    		}
    	}else {
    		cpStr = cpStr.trim();
    		cp = Integer.parseInt(cpStr);
    	}
    	session.setAttribute("cp", cp);
    	String subject = request.getParameter("subject");
    	System.out.println("subject : " + subject);
    	subject = subject.trim();
    	CommuService service = CommuService.getInstance();
    	ListResult listResult = service.getSerchResult(cp ,cpp, subject);
    	
    	
    	
    }*/
    private void write(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	String view = "../sub/2_1_w.jsp";
    	response.sendRedirect(view);
    }
    private void insert(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	
    	ServletContext application = getServletContext();
    	String saveDirectory = application.getRealPath("/file/store");
    	//String saveDirectory = FileSet.FILE_DIR;
    	File fSaveDir = new File(saveDirectory);
    	if(!fSaveDir.exists()) fSaveDir.mkdirs();
    	
    	int maxPostSize = 2*2000*2000;
    	String encoding="utf-8";
    	FileRenamePolicy policy = new DefaultFileRenamePolicy();
    	
    	MultipartRequest mr = null;
    	try {
    		mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);    		
    	}catch(IOException ie) {
    		System.out.println("업로드 실패: "+ie);
    	}
    	
    	String email = mr.getParameter("email");
    	String subject = mr.getParameter("subject");
    	String content = mr.getParameter("content");
    	String fname = mr.getFilesystemName("fname");
        String ofname = mr.getOriginalFileName("ofname");
        
    	CommuService service = CommuService.getInstance();
    	service.insertS(new Community(-1, subject, content, email, null, 0L, fname, ofname));
    	
    	String view = "Commu.do";
    	response.sendRedirect(view);
    }
    private void getBoard(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	
    	int seq = getSeq(request);
    	if( seq != -1) {
    		ServletContext application = getServletContext();
    		String saveDirectory = application.getRealPath("/file/store");
    		File f = new File(saveDirectory);
    		File kids[] = f.listFiles();
    		//if()
    		request.setAttribute("kids", kids);
    		
    		CommuService service = CommuService.getInstance();
    		Community community = service.getBoardS(seq);
    		request.setAttribute("board", community);
    		
    		String view = "";
    		if(m.equals("content")) {
    			view = "../sub/2_1_v.jsp";
    		}else {
    			view = "../sub/2_1_u.jsp";
    		}
    		RequestDispatcher rd = request.getRequestDispatcher(view);
    		rd.forward(request, response);
    	}else {
    		String view = "Commu.do";
    		response.sendRedirect(view);
    	}
    }
    private void updateOk (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	
    	ServletContext application = getServletContext();
    	String saveDirectory = application.getRealPath("/file/store");
    	//String saveDirectory = FileSet.FILE_DIR;
    	File fSaveDir = new File(saveDirectory);
    	if(!fSaveDir.exists()) fSaveDir.mkdirs();
    	
    	int maxPostSize = 2*2000*2000;
    	String encoding="utf-8";
    	FileRenamePolicy policy = new DefaultFileRenamePolicy();
    	
    	MultipartRequest mr = null;
    	try {
    		mr = new MultipartRequest(request, saveDirectory, maxPostSize, encoding, policy);    		
    	}catch(IOException ie) {
    		System.out.println("업로드 실패: "+ie);
    	}
    	
    	int seq = getSeq(request);
    	String subject = mr.getParameter("subject");
    	String content = mr.getParameter("content");
    	String fname = mr.getFilesystemName("fname");
        String ofname = mr.getOriginalFileName("ofname");

    	CommuService service = CommuService.getInstance();
    	service.updateS(new Community(seq, subject, content, null, null, 0L, fname, ofname));
    	
    	String view = "Commu.do";
		response.sendRedirect(view);
    }
    private void download (HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	String fileName = request.getParameter("fname");
		if(fileName != null) fileName = fileName.trim();
		
		ServletContext application = getServletContext();
    	String saveDirectory = application.getRealPath("/file/store");
    	File file = new File(saveDirectory , fileName);
    	
    	response.setContentType("application/octet-stream"); 
		String Agent=request.getHeader("USER-AGENT");
		if( Agent.indexOf("MSIE") >= 0 ){
			int i = Agent.indexOf( 'M', 2 );

			String IEV = Agent.substring( i + 5, i + 8 );

			if( IEV.equalsIgnoreCase("5.5") ){
				response.setHeader("Content-Disposition", "filename=" + new String( fileName.getBytes("utf-8"), "8859_1") );
			}else{
				response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"8859_1"));
			}
		}else{
			response.setHeader("Content-Disposition", "attachment;filename=" + new String( fileName.getBytes("utf-8"), "8859_1") );
		}
    		
		if(file.exists() && file.isFile()) {
			FileInputStream fis = null;
			BufferedInputStream bis = null;
			OutputStream os = null;
			BufferedOutputStream bos = null;
			
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				
				os = response.getOutputStream(); //Data Destination ( 클브라우져 ) 
				bos = new BufferedOutputStream(os);  

				int count = 0;
				byte b[] = new byte[1024];
				while((count = bis.read( b )) != -1){  
					bos.write(b, 0, count);
				}

				bos.flush();
			}catch(IOException ie){
			}finally {
				try {
					if(bos != null) bos.close();
					if(bis != null) bis.close();
					if(fis != null) fis.close();
					if(os != null) os.close();
				}catch(IOException ie) {}
			}
		}
	}
    private void del(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
    	int seq = getSeq(request);
    	ServletContext application = getServletContext();
    	
    	if(seq != -1) {
    		
    		String saveDirectory = application.getRealPath("/file/store");
    		String fname = request.getParameter("fname");
    		File f = new File(saveDirectory, fname); 
    		if(f.exists()) f.delete();
    		
    		CommuService service = CommuService.getInstance();
    		service.delS(seq);
    	}
    	String view = "Commu.do";
		response.sendRedirect(view);
    }
    private int getSeq(HttpServletRequest request) {
    	String setStr = request.getParameter("c_seq");
    	int seq = 0;
    	if(setStr == null) {
    		
    		return -1;
    	}else {
    		setStr = setStr.trim();
    		try {
    			seq = Integer.parseInt(setStr);
    			return seq;
    		}catch(NumberFormatException nfe) {
    			return -1;
    		}
    	}

    }
}
