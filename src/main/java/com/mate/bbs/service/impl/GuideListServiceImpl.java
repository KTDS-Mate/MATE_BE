package com.mate.bbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.bbs.dao.GuideListDao;
import com.mate.bbs.service.GuideListService;

@Service
public class GuideListServiceImpl implements GuideListService{

	@Autowired
	private GuideListDao guideListDao;
	
	
	
	
}
