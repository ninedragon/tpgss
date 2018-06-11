package com.zz.deviceAndData.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.common.dao.DeviceinfoMapper;
import com.zz.common.dao.EeclassificationMapper;
import com.zz.common.dao.EeclassificationgrpMapper;
import com.zz.common.dao.OpdataMapper;
import com.zz.common.dao.OpjumpdataMapper;
import com.zz.deviceAndData.service.DADService;

/**
 * @author 90807
 *
 */
/**
 * @author 90807
 *
 */
/**
 * @author 90807
 * 
 */
@Service
public class DADServiceImpl implements DADService {
	@Autowired
	DeviceinfoMapper deviceinfoMapper;
	@Autowired
	EeclassificationgrpMapper eeclassificationgrpMapper;
	@Autowired
	OpdataMapper opdataMapper;
	@Autowired
	OpjumpdataMapper opjumpdataMapper;
	@Autowired
	EeclassificationMapper eeclassificationMapper;


	

}
