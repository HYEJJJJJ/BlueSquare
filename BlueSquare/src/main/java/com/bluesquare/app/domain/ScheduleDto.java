package com.bluesquare.app.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ScheduleDto {

	private Integer sno;
	private Integer pno;
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private Date timetable;
	
	public ScheduleDto() {}

	public ScheduleDto(Integer pno, Date timetable) {
		this.pno = pno;
		this.timetable = timetable;
	}

	public Integer getSno() {
		return sno;
	}

	public void setSno(Integer sno) {
		this.sno = sno;
	}

	public Integer getPno() {
		return pno;
	}

	public void setPno(Integer pno) {
		this.pno = pno;
	}

	public Date getTimetable() {
		return timetable;
	}

	public void setTimetable(Date timetable) {
		this.timetable = timetable;
	}

	@Override
	public String toString() {
		return "scheduleDto [sno=" + sno + ", pno=" + pno + ", timetable=" + timetable + "]";
	}

}