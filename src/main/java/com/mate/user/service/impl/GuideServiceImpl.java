package com.mate.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mate.access.dao.AccessLogDao;
import com.mate.common.beans.Sha;
import com.mate.user.dao.GuideDao;
import com.mate.user.service.GuideService;
import com.mate.user.vo.RegistGuideVO;

@Service
public class GuideServiceImpl implements GuideService {

	@Autowired
	private GuideDao guideDao;
	
	@Autowired
	private Sha sha;
}
