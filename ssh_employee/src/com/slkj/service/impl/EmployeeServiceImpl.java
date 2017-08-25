package com.slkj.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.slkj.beans.Department;
import com.slkj.beans.Employee;
import com.slkj.beans.PageBean;
import com.slkj.dao.EmployeeDao;
import com.slkj.service.EmployeeService;
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee login(Employee employee) {
		Employee em = employeeDao.findUernameAndPassword(employee);
		return em;
	}

	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		
		//封装每页显示多少条
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//封装总记录数，数据库总条数
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		//计算出分多少页  （记录数 / 每页显示条数） 7条记录数 /每页3条 ==》分3页
		double tc= totalCount;//7
     	Double num =	Math.ceil(tc / pageSize);
		pageBean.setTotalPage(num.intValue());
		
		//封装每页显示数据
		int begin = (currPage - 1)*pageSize;
		//第1页 limit 0，3     数据库下标   0 1 2   取三条
		//第2页 limit 3，3     数据库下标   3 4 5   取三条
		//第3页 limit 6,3   数据库下标     6 7
		List<Employee> list = employeeDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		
		return pageBean;
	}

	@Override
	public void save(Employee employee) {
		employeeDao.saveEmp(employee);
		
	}

	@Override
	public Employee findById(Integer eid) {
		
		return employeeDao.findById(eid);
	}

	@Override
	public void update(Employee employee) {
		employeeDao.updateEmp(employee);
		
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.deleteEmp(employee);
		
	}
	

}
