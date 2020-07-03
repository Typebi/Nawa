package community.model;

import java.util.ArrayList;

import community.vo.ListResult;
import domain.Community;

public class CommuService {
	private CommuDAO dao;
	private static final CommuService instance = new CommuService();
	private CommuService() {
		dao = new CommuDAO();
	}
	public static CommuService getInstance() {
		return instance;
	}
	
	public ListResult getListResult(int currentPage, int pageSize) {
		ArrayList<Community> list = dao.list(currentPage, pageSize);
		long totalCount = dao.getTotalCount();
		ListResult r = new ListResult(currentPage, totalCount, pageSize, list);
		
		return r;
	}
	public ListResult getSearchResult(int currentPage, int pageSize, String subject){
		ArrayList<Community> list = dao.search(currentPage, pageSize,subject);
		long totalCount=dao.getTotalSearchCount();
		ListResult r = new ListResult(currentPage, totalCount, pageSize, list);
		
		return r;
	}
	//
	public ArrayList<Community> listS(){
		return dao.list();
	}
	public Community getBoardS(int c_seq) {
		return dao.getBoard(c_seq);
	}
	public void insertS(Community community) {
		dao.insert(community);
	}
	public void updateS(Community community) {
		System.out.println("dmd");
		dao.update(community);
	}
	public void delS(int seq) {
		dao.del(seq);
	}
}
