package com.bluesquare.app.domain;

public class PerformImgDto {

	private Integer ino;
	private String name;
	private String ori_name;
	private String url;
	private Integer pno;
	
	public PerformImgDto() {}
	
	public PerformImgDto(Integer ino, String name, String ori_name, String url, Integer pno) {
		super();
		this.ino = ino;
		this.name = name;
		this.ori_name = ori_name;
		this.url = url;
		this.pno = pno;
	}

	public void updatePerformImg (String name, String ori_name, String url) {
		this.name = name;
		this.ori_name = ori_name;
		this.url = url;
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

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	@Override
	public String toString() {
		return "performImgDto [ino=" + ino + ", name=" + name + ", ori_name=" + ori_name + ", url=" + url + ", pno=" + pno
				+ "]";
	}
}