package com.zz.common.dao;

import java.util.List;

import com.zz.common.model.CodeInfo;

public interface FaultInfoMapper {
	 public List<CodeInfo> selectTypeList(List<String> codeTypeList);
}