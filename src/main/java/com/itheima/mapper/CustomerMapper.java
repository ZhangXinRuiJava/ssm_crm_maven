package com.itheima.mapper;

import com.itheima.domain.Customer;
import com.itheima.domain.CustomerExample;
import com.itheima.utils.Page;
import com.itheima.vo.QueryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    long countByExample(CustomerExample example);

    int deleteByExample(CustomerExample example);

    int deleteByPrimaryKey(Long custId);

    int insert(Customer record);

    int insertSelective(Customer record);

    List<Customer> selectByExample(CustomerExample example);

    Customer selectByPrimaryKey(Long custId);

    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);
    
    /**
     * 根据queryVo查询客户列表分页数据 
     * @param vo
     * @return
     */
    List<Customer> queryCustomerByQueryVo(QueryVo vo);
    
    /**
     * 根据queryVo查询客户总条数
     * @param vo
     * @return
     */
    Integer queryCustomerCountByQueryVo(QueryVo vo);
}