package com.itheima.service.impl;

import java.util.List;

import com.itheima.domain.Customer;
import com.itheima.mapper.CustomerMapper;
import com.itheima.service.CustomerService;
import com.itheima.utils.Page;
import com.itheima.vo.QueryVo;

public class CustomerServiceImpl implements CustomerService {

	private CustomerMapper customerMapper;

	public CustomerMapper getCustomerMapper() {
		return customerMapper;
	}
	public void setCustomerMapper(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}

	@Override
	public Page<Customer> queryAllCustomer(QueryVo vo) {
		//1 查询客户总条数
		Integer totalCount = customerMapper.queryCustomerCountByQueryVo(vo);
		//2 封装pageBean
		Page<Customer> page = new Page<>(vo.getPage(), vo.getSize(), totalCount);
		//3 查询客户列表并封装到pageBean中
		vo.setStart(page.getStartIndex());//设置limit第一个参数
		List<Customer> list = customerMapper.queryCustomerByQueryVo(vo);
		page.setRows(list);
		return page;
	}
	
	@Override
	public Customer findCustomerById(String id) {
		Customer customer = customerMapper.selectByPrimaryKey(Long.parseLong(id));
		return customer;
	}
	
	@Override
	public Integer updateCustomerById(Customer customer) {
		int i = customerMapper.updateByPrimaryKey(customer);
		return i;
	}
	
	@Override
	public Integer deleteCustomerById(String id) {
		int i = customerMapper.deleteByPrimaryKey(Long.parseLong(id));
		return i;
	}
	
	@Override
	public List<Customer> test() {
		List<Customer> list = customerMapper.selectByExample(null);
		return list;
	}

}
