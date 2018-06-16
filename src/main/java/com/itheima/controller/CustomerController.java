package com.itheima.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.itheima.domain.BaseDict;
import com.itheima.domain.Customer;
import com.itheima.service.BaseDictService;
import com.itheima.service.CustomerService;
import com.itheima.utils.Page;
import com.itheima.vo.QueryVo;

@Controller
public class CustomerController {
	
	@Resource(name="customerService")
	private CustomerService customerService;
	
	@Resource(name="baseDictService")
	private BaseDictService baseDictService;
	
	//3个常量 字典类型编码,解决硬编码问题
	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;
	
	/**
	 * 查询客户列表，条件分页
	 * @param model
	 * @return
	 */
	@RequestMapping("queryAllCustomer.action")
	public String queryAllCustomer(QueryVo vo,Model model){
		System.out.println("前端传入:"+vo);
		//查询字典数据
		List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_FROM_TYPE);//客户来源
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_INDUSTRY_TYPE);//客户行业
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_LEVEL_TYPE);//客户级别
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		
		//查询用户列表数据
		Page<Customer> page = customerService.queryAllCustomer(vo);
		model.addAttribute("page", page);//此处name必须为page，否则分页无法正常显示
		
		// 查询条件数据回显 后台版，或者使用param回显
		/*model.addAttribute("custName", vo.getCustName());
		model.addAttribute("custSource", vo.getCustSource());
		model.addAttribute("custIndustry", vo.getCustIndustry());
		model.addAttribute("custLevel", vo.getCustLevel());*/
		
		System.out.println("后台设置部分:"+vo);
		return "customer";
	}
	
	//数据回显，新式
	@RequestMapping("customerEdit.action")
	@ResponseBody
	public Customer customerEdit(String id,HttpServletResponse response){//失败
		System.out.println("前端传id:"+id);
		Customer customer = customerService.findCustomerById(id);
		System.out.println("查询客户："+customer);
		return customer;
	}
	
	//数据回显，老式
	/*@RequestMapping("customerEdit.action")
	public void customerEdit(String id,HttpServletResponse response) throws IOException{//成功
		System.out.println("前端传id:"+id);
		Customer customer = customerService.findCustomerById(id);
		System.out.println("查询客户："+customer);
		
		String jsonString = JSON.toJSONString(customer);
		System.out.println("json:"+jsonString);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write(jsonString);
	}*/
	
	/**
	 * 保存修改
	 * @param customer
	 * @return
	 */
	@RequestMapping("customerUpdate.action")
	@ResponseBody
	public String customerUpdate(Customer customer){
		System.out.println("保存修改前："+customer);
		Integer row = customerService.updateCustomerById(customer);
		return row.toString();//返回数据是为了让ajax的成功函数执行，进而刷新页面
	}
	
	/**
	 * 删除客户
	 * @param id
	 * @return
	 */
	@RequestMapping("customerDelete.action")
	@ResponseBody
	public String customerDelete(String id){
		Integer row = customerService.deleteCustomerById(id);
		return row.toString();
	}
	
	//测试
	@RequestMapping("test.action")
	public String test(Model model){
		//查询字典数据
		List<BaseDict> fromType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_FROM_TYPE);//客户来源
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_INDUSTRY_TYPE);//客户行业
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(CUSTOMER_LEVEL_TYPE);//客户级别
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		//查询用户列表数据
		List<Customer> list = customerService.test();
		model.addAttribute("customerList", list);
		return "customer";
	}
	
}
