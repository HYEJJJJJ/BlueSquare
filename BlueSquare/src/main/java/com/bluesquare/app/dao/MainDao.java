package com.bluesquare.app.dao;

import java.util.List;

import com.bluesquare.app.domain.MainPerformDto;

public interface MainDao {

	public List<MainPerformDto> mainPerformList();
	
	MainPerformDto select(int pno) throws Exception;

}