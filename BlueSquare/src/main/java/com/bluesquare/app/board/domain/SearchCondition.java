package com.bluesquare.app.board.domain;



import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {
	
	private Integer page=1;
	private Integer pageSize=10;
	private String option="";
	private String keyword;

	
	public SearchCondition() {}

	public SearchCondition(Integer page, Integer pageSize, String option, String keyword) {
		
		this.page = page;
		this.pageSize = pageSize;
		this.option = option;
		this.keyword = keyword;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	
	public String getQueryString() {
		return getQueryString(page);
	}
	
	//검색한 내용을 넘겨줄때
	public String getQueryString(Integer page) {
		
		return UriComponentsBuilder.newInstance()
				.queryParam("page", page)
				.queryParam("pageSize", pageSize)
				.queryParam("option", option)
				.queryParam("keyword", keyword)
				.build().toString();
	}

	@Override
	public String toString() {
		return "SearchCondition [page=" + page + ", pageSize=" + pageSize + ", option=" + option + ", keyword="
				+ keyword + "]";
	}
	
}
