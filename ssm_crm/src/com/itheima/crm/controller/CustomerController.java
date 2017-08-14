package com.itheima.crm.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.common.utils.Page;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.QueryVo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private BaseDictService baseDictService;
	@Value("${CUSTOMER_FORM_TYPE}")
	private String formTypeString;
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String industryTypeString;
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String levelTypeString;
	
	@RequestMapping("list")
	public String queryCustomerList(Model model,QueryVo queryVo){
		try{
			//解决get请求乱码问题
			if(StringUtils.isNotBlank(queryVo.getCustName())){
				queryVo.setCustName(new String(queryVo.getCustName().getBytes("ISO-8859-1"),"UTF-8"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		//客户来源
		List<BaseDict> formType = baseDictService.queryBaseDictByDictTypeCode(formTypeString);
		//所属行业
		List<BaseDict> industryType = baseDictService.queryBaseDictByDictTypeCode(industryTypeString);
		//客户级别
		List<BaseDict> levelType = baseDictService.queryBaseDictByDictTypeCode(levelTypeString);
		//把前端页面需要显示的数据放到模型中
		model.addAttribute("formType",formType);
		model.addAttribute("industryType",industryType);
		model.addAttribute("levelType",levelType);
		
		//分页查询数据
		Page<Customer> page = customerService.queryCustomerByQueryVo(queryVo);
		//把分页查询的结果放到模型中
		model.addAttribute("page",page);
		//数据回显
		model.addAttribute("custName", queryVo.getCustName());
		model.addAttribute("custSource", queryVo.getCustSource());
		model.addAttribute("custIndustry", queryVo.getCustIndustry());
		model.addAttribute("custLevel", queryVo.getCustLevel());
		
		return "customer";
	}
	
	//编辑功能：根据Id回显客户数据
	@RequestMapping("edit")
	public @ResponseBody
	Customer editOne(Long id){
		return customerService.findCustomerById(id);
	}
	//保存修改功能
	@RequestMapping("update")
	public @ResponseBody 
	String update(Customer customer){
		customerService.updateCustomer(customer);
		return "OK";
	}
	//删除功能
	@RequestMapping("delete")
	public @ResponseBody 
	String delete(Long id){
		if(id!=null)
		customerService.deleteCustomer(id);
		return "OK";
	}
}
