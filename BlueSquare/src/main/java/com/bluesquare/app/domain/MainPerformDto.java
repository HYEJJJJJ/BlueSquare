package com.bluesquare.app.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class MainPerformDto {

	private Integer pno;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startday;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endday;
	private Integer runtime;
	private String actors;
	private Integer price;
	private Integer ino;
	private String name;
	private String ori_name;
	private String url;
	
	public MainPerformDto() {}

	public MainPerformDto(Integer pno, String title, Date startday, Date endday, Integer runtime, String actors,
			Integer price, Integer ino, String name, String ori_name, String url) {
		super();
		this.pno = pno;
		this.title = title;
		this.startday = startday;
		this.endday = endday;
		this.runtime = runtime;
		this.actors = actors;
		this.price = price;
		this.ino = ino;
		this.name = name;
		this.ori_name = ori_name;
		this.url = url;
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

	public Integer getIno() {
		return ino;
	}

	public void setIno(Integer ino) {
		this.ino = ino;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOri_name() {
		return ori_name;
	}

	public void setOri_name(String ori_name) {
		this.ori_name = ori_name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "MainPerformDto [pno=" + pno + ", title=" + title + ", startday=" + startday + ", endday=" + endday
				+ ", runtime=" + runtime + ", actors=" + actors + ", price=" + price + ", ino=" + ino + ", name=" + name
				+ ", ori_name=" + ori_name + ", url=" + url + "]";
	}
}