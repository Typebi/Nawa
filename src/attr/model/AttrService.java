package attr.model;

import java.util.ArrayList;

import attr.vo.ListResult;
import domain.Attr;

public class AttrService {
	private AttrDAO dao;
	private static final AttrService instance=new AttrService();
	
	private AttrService() {
		dao=new AttrDAO();
	}
	public static AttrService getInstance() {
		return instance;
	}
	public ListResult getListResult(int currentPage, int pageSize) {//현재페이지와, 그페이지의 게시물 갯수
		ArrayList<Attr> list = dao.list(currentPage, pageSize);
		long totalCount=dao.getTotalCount();
		ListResult r = new ListResult(currentPage,  list, totalCount, pageSize);
		
		return r;
	}
	public ListResult getSearchResult(int currentPage, int pageSize, String subject){
		ArrayList<Attr> list = dao.search(currentPage, pageSize,subject);
		long totalCount=dao.getTotalSearchCount();
		ListResult r = new ListResult(list, currentPage, totalCount, pageSize );
		
		return r;
	}
	
	public ArrayList<Attr> listS(){
		return dao.list();
	}
	public ArrayList<Attr> listS(int area_no){
		return dao.list(area_no);
	}
	
	public void insertS(Attr dto) {
		dao.insert(dto);
	}
	public boolean delS(int attr_seq) {
		return dao.del(attr_seq);
	}
}
