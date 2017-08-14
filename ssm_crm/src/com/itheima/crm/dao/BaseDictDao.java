package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.pojo.BaseDict;

public interface BaseDictDao {
	/**
	 * 根据类别代码查询数据
	 * 
	 * @param dictTypeCode
	 * @return
	 */
	List<BaseDict> queryBaseDictByDictTypeCode(String dictTypeCode);
	
}
