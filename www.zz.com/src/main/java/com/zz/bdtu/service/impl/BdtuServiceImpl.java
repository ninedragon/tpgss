package com.zz.bdtu.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zz.bdtu.service.BdtuService;
import com.zz.common.dao.BdtuMapper;
import com.zz.common.dao.TSyCityInfoMapper;
import com.zz.common.dao.TSyCodeDefimeMapper;
import com.zz.common.dao.TSyprovincesInfoMapper;
import com.zz.common.model.Dtu;
import com.zz.core.mybatis.BaseMybatisDao;
import com.zz.core.mybatis.page.Pagination;

/**
 * 
 */
@Service
public class BdtuServiceImpl extends BaseMybatisDao<BdtuMapper> implements BdtuService {
	
	@Autowired
	TSyprovincesInfoMapper tSyprovincesInfoMapper;
	@Autowired
	TSyCityInfoMapper tsycityInfoMapper;
	@Autowired
	TSyCodeDefimeMapper codeDefimeMapper;
	@Autowired
	BdtuMapper bdtuMapper;

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
		   dtuTmp= bdtuMapper.selectMaxId(0);
		   if(dtuTmp!=null)
		   {
			   insertId=dtuTmp.getId();
		   }
			insertInt= bdtuMapper.insertSelective(dtu);
         }
		else
		{
			insertInt = bdtuMapper.updateByPrimaryKeySelective(dtu);
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("status", insertInt);
		map.put("id", insertId+1);//插入 id=max(id)+1
		return map;
	}
	
	  public Map<String, Object> delDtu(int  id){
		int  i = bdtuMapper.deleteByPrimaryKey(id);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("stauts", i);
		return map;
	}
	  
	  public   Dtu selectDtuByRowId(int id)
		 {
			return   bdtuMapper.selectByPrimaryKey(id);
		 }
	
     
	 
}
