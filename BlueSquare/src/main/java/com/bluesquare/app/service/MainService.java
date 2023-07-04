package com.bluesquare.app.service;

import java.util.List;

import com.bluesquare.app.domain.MainPerformDto;

public interface MainService {

	List<MainPerformDto> mainPerformList();

	MainPerformDto read(int pno) throws Exception;
}