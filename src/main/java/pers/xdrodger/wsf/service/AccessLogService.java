package pers.xdrodger.wsf.service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pers.xdrodger.wsf.dao.AccessLogDao;
import pers.xdrodger.wsf.entity.AccessLog;

/**
 * 券营销可售券定义service
 * 
 * @author xudongdong
 *         2015年11月17日 下午4:19:32
 */
@Service
public class AccessLogService {

	private static final Logger logger = LoggerFactory.getLogger(AccessLogService.class);
	
	@Autowired
	private AccessLogDao accessLogDao;
	
	@Transactional
	public void process() {
		AccessLog accessLog = new AccessLog();
		accessLog.setId(UUID.randomUUID().toString().replace("", ""));
		accessLog.setInfo("test-");
		accessLog.setCreateTime(new Date());
		accessLogDao.add(accessLog);
		
		List<AccessLog> accessLogs =  accessLogDao.getAll();
	}

}
