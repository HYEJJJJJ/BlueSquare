package com.bluesquare.app.dao;

import com.bluesquare.app.domain.PerformDto;
import com.bluesquare.app.domain.ScheduleDto;
import com.bluesquare.app.domain.PerformImgDto;

public interface AdminDao {

	int performReg(PerformDto dto);

	int performImgReg(PerformImgDto dto);
	
	int performScheReg(ScheduleDto dto);

	int performDel(Integer pno);

	int performEdit(PerformDto dto);

}