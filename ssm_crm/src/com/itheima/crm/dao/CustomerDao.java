package com.itheima.crm.dao;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerDao {

	/**
	 * 根据queryVo分页查询数据
	 * 
	 * @param queryVo
	 * @return
	 */
	List<Customer> queryCustomerByQueryVo(QueryVo queryVo);

	/**
	 * 根据queryVo查询数据条数
	 * 
	 * @param queryVo
	 * @return
	 */
	int queryCountByQueryVo(QueryVo queryVo);

	/**
	 * 根据Id查询客户
	 * @param id
	 * @return
	 */
	Customer findCustomerById(Long id);

	/**
	 * 根据Id保存或修改客户
	 * @param customer
	 */
	void updateCustomer(Customer customer);

	/**
	 * 通过Id删除客户
	 * @param id
	 */
	void deleteCustomer(Long id);
}
