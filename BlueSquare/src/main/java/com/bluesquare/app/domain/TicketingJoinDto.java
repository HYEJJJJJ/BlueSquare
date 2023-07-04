package com.bluesquare.app.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TicketingJoinDto {

	private Integer pno;
	private Integer sno;
	private Integer tno;
	private String id;
	private Integer seat;
	private Date tkt_date;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date timetable;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startday;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endday;
	private Integer runtime;
	private String actors;
	private Integer price;
	
	public TicketingJoinDto() {}

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Integer getTno() {
		return tno;
	}

	public void setTno(Integer tno) {
		this.tno = tno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSeat() {
		return seat;
	}

	public void setSeat(Integer seat) {
		this.seat = seat;
	}

	public Date getTkt_date() {
		return tkt_date;
	}

	public void setTkt_date(Date tkt_date) {
		this.tkt_date = tkt_date;
	}

	public Date getTimetable() {
		return timetable;
	}

	public void setTimetable(Date timetable) {
		this.timetable = timetable;
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
	
}