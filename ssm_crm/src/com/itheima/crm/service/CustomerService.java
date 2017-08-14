package com.itheima.crm.service;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

public interface CustomerService {

	/**
	 * 根据条件分页查询客户
	 * 
	 * @param queryVo
	 * @return
	 */
	Page<Customer> queryCustomerByQueryVo(QueryVo queryVo);

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
