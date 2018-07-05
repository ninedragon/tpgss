package com.zz.deviceAndData.service;

import com.zz.common.model.Opdata;
import com.zz.deviceAndData.bo.NDTUData;

public interface DataCollectionService {
	// 主要分为两步数据校验和数据处理，其实没必要写接口
	// dataProcess--> (datavalid,dataAnalysis(isnertdata)),感觉这么写麻烦了，应该直接写就行，直接只要dataValid和dataAnaysis作为public方法，insert作为private方法
	public int dataValidation(NDTUData ndtudata);

	public Opdata dataAnalysis(NDTUData ndtudata);

	/**
	 * @param ndtuOpdata
	 * @return -1表示异常，0表示成功
	 */
	public int dataProcess(NDTUData ndtudata);

	public int insertData(Object Object);

	public void dealReceiveData(NDTUData ndtudata);
}
