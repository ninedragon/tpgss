package com.zz.common.timer;

import com.zz.common.dao.t_cal_zMapper;
import com.zz.common.utils.TimesegmentUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时计算阻抗数据
 */
@Component
public class CalZTimer {
    protected final static Logger logger = Logger.getLogger(CalZTimer.class);
    @Autowired
    t_cal_zMapper t_cal_zMapper1;
    //	@Scheduled(cron = "0/20 * * * * ? ")
//    @Scheduled(cron = "0/30 * * * * ?  ")每30秒执行一次
    @Scheduled(cron = "0 15 0 * * ?   ")//每一天的00：15执行一次
//    @Scheduled(cron = "0 47,48 14 * * ? ")//每一天的14点 47,48执行一次

    public void run() {
        /**
         * 调用存储过程，重新创建表，插入初始化数据。
         */
//		roleService.initData();

        logger.info("开始计算阻抗数据");
        t_cal_zMapper1.cal_topo_all();
        logger.info("完成计算阻抗数据");
    }
}
