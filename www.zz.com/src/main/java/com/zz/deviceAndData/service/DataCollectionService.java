package com.zz.deviceAndData.service;

import com.zz.common.model.Opdata;
import com.zz.deviceAndData.bo.NDTUData;

public interface DataCollectionService {
	public int dataFetch(NDTUData ndtudata);

	public Opdata dataAnalysis(NDTUData ndtudata);

	/**
	 * @param ndtuOpdata
	 * @return -1表示异常，0表示成功
	 */
	public int dataProcess(NDTUData ndtudata);

	public int insertData(Object Object);
}
