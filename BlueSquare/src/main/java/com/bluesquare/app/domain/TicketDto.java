package com.bluesquare.app.domain;

import java.util.Date;

public class TicketDto {
	private Integer tno;
	private String id;
	private Integer sno;
	private Integer seat;
	private Date tkt_date;
	

	public TicketDto() {}

	public TicketDto(String id, Integer sno, Integer seat) {
		this.id = id;
		this.sno = sno;
		this.seat = seat;
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

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
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

	@Override
	public String toString() {
		return "TicketDto [tno=" + tno + ", id=" + id + ", sno=" + sno + ", seat=" + seat + ", tkt_date=" + tkt_date
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((seat == null) ? 0 : seat.hashCode());
		result = prime * result + ((sno == null) ? 0 : sno.hashCode());
		result = prime * result + ((tkt_date == null) ? 0 : tkt_date.hashCode());
		result = prime * result + ((tno == null) ? 0 : tno.hashCode());
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
		TicketDto other = (TicketDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (seat == null) {
			if (other.seat != null)
				return false;
		} else if (!seat.equals(other.seat))
			return false;
		if (sno == null) {
			if (other.sno != null)
				return false;
		} else if (!sno.equals(other.sno))
			return false;
		if (tkt_date == null) {
			if (other.tkt_date != null)
				return false;
		} else if (!tkt_date.equals(other.tkt_date))
			return false;
		if (tno == null) {
			if (other.tno != null)
				return false;
		} else if (!tno.equals(other.tno))
			return false;
		return true;
	}
}