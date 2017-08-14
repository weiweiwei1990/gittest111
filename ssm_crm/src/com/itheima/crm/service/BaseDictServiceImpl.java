package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.dao.BaseDictDao;
import com.itheima.crm.pojo.BaseDict;

@Service
public class BaseDictServiceImpl implements BaseDictService {

	@Autowired
	private BaseDictDao dao;
	
	@Override
	public List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode) {
		
		return dao.queryBaseDictByDictTypeCode(dictTypeCode);
	}

}
