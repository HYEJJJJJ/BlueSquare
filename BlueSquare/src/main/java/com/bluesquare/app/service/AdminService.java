package com.bluesquare.app.service;

import org.springframework.web.multipart.MultipartFile;

import com.bluesquare.app.domain.PerformDto;
import com.bluesquare.app.domain.ScheduleDto;

public interface AdminService {

	int performReg(PerformDto dto);

	int performImgReg(MultipartFile performImg);
	
	public int performScheReg(ScheduleDto dto);

	int performDel(Integer pno);

	int performEdit(PerformDto dto);

}