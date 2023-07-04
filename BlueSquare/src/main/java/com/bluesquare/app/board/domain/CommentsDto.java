package com.bluesquare.app.board.domain;

import java.util.Date;

public class CommentsDto {
	
	private Integer cno;
	private Integer bno;
	private Integer pcno;
	private String comments;
	private String commenter;
	private Date reg_date;
	private Date up_date;
	
	public CommentsDto() {}

	public CommentsDto(Integer bno, Integer pcno, String comments, String commenter) {
		super();
		this.bno = bno;
		this.pcno = pcno;
		this.comments = comments;
		this.commenter = commenter;
	}

	public Integer getCno() {
		return cno;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public Integer getBno() {
		return bno;
	}

	public void setBno(Integer bno) {
		this.bno = bno;
	}

	public Integer getPcno() {
		return pcno;
	}

	public void setPcno(Integer pcno) {
		this.pcno = pcno;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCommenter() {
		return commenter;
	}

	public void setCommenter(String commenter) {
		this.commenter = commenter;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Date getUp_date() {
		return up_date;
	}

	public void setUp_date(Date up_date) {
		this.up_date = up_date;
	}

	@Override
	public String toString() {
		return "CommentsDto [cno=" + cno + ", bno=" + bno + ", pcno=" + pcno + ", comments=" + comments + ", commenter="
				+ commenter + ", reg_date=" + reg_date + ", up_date=" + up_date + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bno == null) ? 0 : bno.hashCode());
		result = prime * result + ((cno == null) ? 0 : cno.hashCode());
		result = prime * result + ((commenter == null) ? 0 : commenter.hashCode());
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((pcno == null) ? 0 : pcno.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentsDto other = (CommentsDto) obj;
		if (bno == null) {
			if (other.bno != null)
				return false;
		} else if (!bno.equals(other.bno))
			return false;
		if (cno == null) {
			if (other.cno != null)
				return false;
		} else if (!cno.equals(other.cno))
			return false;
		if (commenter == null) {
			if (other.commenter != null)
				return false;
		} else if (!commenter.equals(other.commenter))
			return false;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (pcno == null) {
			if (other.pcno != null)
				return false;
		} else if (!pcno.equals(other.pcno))
			return false;
		return true;
	};
	
	
	
}




