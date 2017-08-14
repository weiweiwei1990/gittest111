package com.itheima.crm.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.common.utils.Page;
import com.itheima.crm.dao.CustomerDao;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao dao;
	@Override
	public Page<Customer> queryCustomerByQueryVo(QueryVo queryVo) {
		//设置查询条件，从哪一条数据开始查
		queryVo.setStart((queryVo.getPage()-1)*queryVo.getRows());
		//查询数据结果集
		List<Customer> list = dao.queryCustomerByQueryVo(queryVo);
		//查询到的数据总条数
		int total = dao.queryCountByQueryVo(queryVo);
		//封装返回的page对象
		Page<Customer> page = new Page<Customer>(total,queryVo.getPage(),queryVo.getRows(),list);
		return page;
	}
	//根据Id查询客户
	@Override
	public Customer findCustomerById(Long id) {
		
		return dao.findCustomerById(id);
	}
	//根据Id保存或修改客户
	@Override
	public void updateCustomer(Customer customer) {
		dao.updateCustomer(customer);
		
	}
	//根据Id删除客户
	@Override
	public void deleteCustomer(Long id) {
		dao.deleteCustomer(id);
		
	}

}
