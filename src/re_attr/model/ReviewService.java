package re_attr.model;

import java.util.ArrayList;

import domain.Attr;
import domain.Reply;
import domain.Review;
import re_attr.vo.ListResult;

public class ReviewService {
	private ReviewDAO dao;
	private static final ReviewService instance= new ReviewService();
	
	private ReviewService() {
		dao=new ReviewDAO();
	}
	public static ReviewService getInstance() {
		return instance;
	}
	public ListResult getListResult(int currentPage, int pageSize, int attr_seq) {
		ArrayList<Review> reviews = dao.listingReview(currentPage, pageSize, attr_seq); //∏Æ∫‰ ∏ÆΩ∫∆√
		long totalCount=dao.getTotalCount(); //∆‰¿Ã¬°
		ListResult r = new ListResult(currentPage, totalCount, pageSize, reviews); //∆‰¿Ã¬°
		return r;
	}
	public Attr getAttr(int attr_seq) {
		return dao.getAttrFromDB(attr_seq);
	}
	public void insertS(Review dto) {
		dao.insert(dto);
	}
	public boolean delS(int re_seq) {
		return dao.del(re_seq);
	}
	public void recommend(Review dto) {
		dao.recommend(dto);
	}
	public void insertC(Reply dto) {
		dao.insertC(dto);
	}
	public ArrayList<Review> contentS(int re_seq){
		return dao.content(re_seq);
	}
	public boolean updateS(int re_seq,String review_subject,int rate,String review_content){
		return dao.update(re_seq,review_subject,rate,review_content);
	}
	public boolean delC(int re_seq,int comm_seq) {
		return dao.delC(re_seq,comm_seq);
	}
}
