package re_attr.vo;

import java.util.List;

import domain.Review;

public class ListResult {
	private int currentPage;//현재페이지
	private long totalCount;//총게시물갯수
	private int pageSize=10;//한페이지의 게시물 갯수
	private List<Review> list;
	private long totalPageCount;
	
	public ListResult() {}
	public ListResult(int currentPage, long totalCount, int pageSize, List<Review> list) {
		this.currentPage=currentPage;
		this.totalCount = totalCount;
		this.pageSize=pageSize;
		this.list=list;
		this.totalPageCount = calTotalPageCount();
	}
	private long calTotalPageCount() {
		long tpc=totalCount/pageSize;
		if(totalCount%pageSize != 0) {
			tpc++;
		}
		return tpc;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public long getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<Review> getList() {
		return list;
	}
	public void setList(List<Review> list) {
		this.list = list;
	}
	public long getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(long totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
}
