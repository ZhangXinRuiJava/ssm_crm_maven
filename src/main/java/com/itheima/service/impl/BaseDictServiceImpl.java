package com.itheima.service.impl;

import java.util.List;

import com.itheima.domain.BaseDict;
import com.itheima.domain.BaseDictExample;
import com.itheima.mapper.BaseDictMapper;
import com.itheima.service.BaseDictService;

public class BaseDictServiceImpl implements BaseDictService {

	private BaseDictMapper baseDictMapper;

	public BaseDictMapper getBaseDictMapper() {
		return baseDictMapper;
	}
	public void setBaseDictMapper(BaseDictMapper baseDictMapper) {
		this.baseDictMapper = baseDictMapper;
	}

	@Override
	public List<BaseDict> queryBaseDictByDictTypeCode(String typeCode) {
		BaseDictExample example = new BaseDictExample();
		example.createCriteria().andDictTypeCodeEqualTo(typeCode);
		List<BaseDict> list = baseDictMapper.selectByExample(example);
		return list;
	}

}
