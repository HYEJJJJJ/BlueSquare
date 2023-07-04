package com.bluesquare.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluesquare.app.dao.MainDao;
import com.bluesquare.app.domain.MainPerformDto;

@Service
public class MainServiceImpl implements MainService{

	@Autowired
	MainDao mainDao;
	
	//전체 공연 목록
	@Override
	public List<MainPerformDto> mainPerformList() {
		return mainDao.mainPerformList();
	}

	//전체 공연 가져오기
	@Override
	public MainPerformDto read(int pno) throws Exception {
		MainPerformDto mainPerformDto = mainDao.select(pno);
		return mainPerformDto;
	}

}