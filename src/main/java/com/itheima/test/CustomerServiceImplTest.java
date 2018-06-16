package com.itheima.test;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.itheima.domain.Customer;
import com.itheima.service.CustomerService;

@ContextConfiguration("classpath:applicationContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplTest {
	
	@Resource(name="customerService")
	private CustomerService customerService;
	
	@Test
	public void test() {
		List<Customer> list = customerService.test();
		for (Customer customer : list) {
			System.out.println("**:"+customer);
		}
	}

}
