package com.bluesquare.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bluesquare.app.dao.AdminDao;
import com.bluesquare.app.domain.PerformDto;
import com.bluesquare.app.domain.PerformImgDto;
import com.bluesquare.app.domain.ScheduleDto;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao dao;
	
	//공연 등록
	@Override
	public int performReg(PerformDto dto) {
		return dao.performReg(dto);
	}
	
	//공연 이미지 등록
	@Override
	public int performImgReg(MultipartFile performImg) {
		PerformImgDto dto = new PerformImgDto();
		String performImgLocation = "C:/BlueSquare/perform";
		String oriName = performImg.getOriginalFilename();
		String name = "";
		String url = "";
		if(!performImg.isEmpty()) {
			try {
				name = FileService.uploadFile(performImgLocation, oriName, performImg.getBytes());
			} catch (Exception e) {
				e.printStackTrace();
			}
			url = "/images/perform/" + name;
		}
		dto.updatePerformImg(name, oriName, url);
		return dao.performImgReg(dto);
	}
	
	//공연 정보 수정
	@Override
	public int performEdit(PerformDto dto) {
		return dao.performEdit(dto);
	}
	
	//공연 일정 추가
	@Override
	public int performScheReg(ScheduleDto dto) {
		return dao.performScheReg(dto);
	}
	
	//공연 삭제
	@Override
	public int performDel(Integer pno) {
		return dao.performDel(pno);
	}
}