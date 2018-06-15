package com.zz.ndtu.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.common.dao.NdtuMapper;
import com.zz.common.dao.TSyCityInfoMapper;
import com.zz.common.dao.TSyCodeDefimeMapper;
import com.zz.common.dao.TSyprovincesInfoMapper;
import com.zz.common.model.Dtu;
import com.zz.core.mybatis.BaseMybatisDao;
import com.zz.core.mybatis.page.Pagination;
import com.zz.ndtu.service.NdtuService;

/**
 * 
 */
@Service
public class NdtuServiceImpl extends BaseMybatisDao<NdtuMapper> implements NdtuService {
	
	@Autowired
	TSyprovincesInfoMapper tSyprovincesInfoMapper;
	@Autowired
	TSyCityInfoMapper tsycityInfoMapper;
	@Autowired
	TSyCodeDefimeMapper codeDefimeMapper;
	@Autowired
	NdtuMapper ndtuMapper;

	@Override
	public Pagination<Dtu> findByPage(Map<String, Object> resultMap,
			Integer pageNo, Integer pageSize) {
		return super.findPage(resultMap, pageNo, pageSize);
	}
	
	
	public Map<String, Object> updateDtu(Dtu dtu,String flag) {		
        int  insertInt=0;
        int insertId=0;
        Dtu dtuTmp=new Dtu();
	   if("0".equals(flag))
        {
		   dtuTmp= ndtuMapper.selectMaxId(0);
		   if(dtuTmp!=null)
		   {
			   insertId=dtuTmp.getId();
		   }
			insertInt= ndtuMapper.insertSelective(dtu);
         }
		else
		{
			insertInt = ndtuMapper.updateByPrimaryKeySelective(dtu);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", insertInt);
		map.put("id", insertId+1);//插入 id=max(id)+1
		return map;
	}
	
	  public Map<String, Object> delDtu(int  id){
		int  i = ndtuMapper.deleteByPrimaryKey(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stauts", i);
		return map;
	}
	  
	  public   Dtu selectDtuByRowId(int id)
		 {
			return   ndtuMapper.selectByPrimaryKey(id);
		 }
	
     
	 
}
