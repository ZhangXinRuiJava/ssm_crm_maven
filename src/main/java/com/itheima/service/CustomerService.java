package com.itheima.service;

import java.util.List;

import com.itheima.domain.Customer;
import com.itheima.utils.Page;
import com.itheima.vo.QueryVo;

public interface CustomerService {
	
	/**
	 * 根据queryVo查询所有客户
	 * @return
	 */
	public Page<Customer> queryAllCustomer(QueryVo vo);
	
	/**
	 * 根据id查询客户
	 * @param id
	 * @return
	 */
	public Customer findCustomerById(String id);
	
	/**
	 * 根据id修改客户
	 * @param customer
	 * @return
	 */
	public Integer updateCustomerById(Customer customer);
	
	/**
	 * 根据id删除客户
	 * @param id
	 */
	public Integer deleteCustomerById(String id);
	
	public List<Customer> test();
	
}
