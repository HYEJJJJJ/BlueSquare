package com.bluesquare.app.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PerformDto {

	private Integer pno;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startday;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endday;
	private Integer runtime;
	private String actors;
	private Integer price;
	
	public PerformDto() {}

	public PerformDto(String title, Date startday, Date endday, Integer runtime, String actors, Integer price) {
		this.title = title;
		this.startday = startday;
		this.endday = endday;
		this.runtime = runtime;
		this.actors = actors;
		this.price = price;
	}

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getStartday() {
		return startday;
	}

	public void setStartday(Date startday) {
		this.startday = startday;
	}

	public Date getEndday() {
		return endday;
	}

	public void setEndday(Date endday) {
		this.endday = endday;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "PerformDto [pno=" + pno + ", title=" + title + ", startday=" + startday + ", endday=" + endday
				+ ", runtime=" + runtime + ", actors=" + actors + ", price=" + price + "]";
	}
	
}