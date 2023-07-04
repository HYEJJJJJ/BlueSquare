package com.bluesquare.app.board.domain;

public class PageHandler {
	private int totalCnt; //총 게시글 갯수
	private int naviSize=10; //페이지 네비게이션의 크기 //=10; 명시적 초기화로 10 
	private int totalPage; //전체 페이지의 개수
	private int beginPage; //페이지 네비게이션의 첫번째 페이지
	private int endPage; // 페이지 네비게이션의 마지막 페이지
	private boolean showPrev; //이전 페이지로 이동하는 버튼 표시 여부
	private boolean showNext; //다음 페이지로 이동하는 버튼 표시 여부
	private SearchCondition sc;
	
	
	public PageHandler(int totalCnt, SearchCondition sc) {
		this.totalCnt = totalCnt;
		this.sc = sc;
		
		doPaging(totalCnt, sc);
	}
	
	public SearchCondition getSc() {
		return sc;
	}

	public void setSc(SearchCondition sc) {
		this.sc = sc;
	}


	public void doPaging(int totalCnt, SearchCondition sc) {
		
		this.totalCnt = totalCnt;
		
		//전체 페이지 개수 계산
		totalPage = (int) Math.ceil(totalCnt/ (double)sc.getPageSize());
		
		//시작페이지
		beginPage = (sc.getPage()-1)/ naviSize * naviSize +1;
		
		//마지막페이지 //계산한거랑 전체페이지랑 둘중에 더 작은거 ~!
		endPage = Math.min(beginPage + naviSize -1, totalPage);
		
		//페이지 버튼 표시
		showPrev = beginPage != 1;
		showNext = endPage != totalPage;
	}

	void print() {
		System.out.println("page : " + sc.getPage());
		
		System.out.println(showPrev ? "[prev]" : "");
		
		for (int i=beginPage; i<=endPage; i++) {
			System.out.println(i+ " ");
			
			System.out.println(showNext ? "[next]" : "");
		}
		
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}


	public int getNaviSize() {
		return naviSize;
	}

	public void setNaviSize(int naviSize) {
		this.naviSize = naviSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isShowPrev() {
		return showPrev;
	}

	public void setShowPrev(boolean showPrev) {
		this.showPrev = showPrev;
	}

	public boolean isShowNext() {
		return showNext;
	}

	public void setShowNext(boolean showNext) {
		this.showNext = showNext;
	}
	
}
