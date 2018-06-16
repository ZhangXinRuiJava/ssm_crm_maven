package com.itheima.service;

import java.util.List;

import com.itheima.domain.BaseDict;

public interface BaseDictService {
	
	/**
	 * 根据字典类型代码查询字典数据集合
	 * @param typeCode
	 * @return
	 */
	public List<BaseDict> queryBaseDictByDictTypeCode(String typeCode);
	
}
