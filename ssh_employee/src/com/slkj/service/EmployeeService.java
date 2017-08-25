package com.slkj.service;

import com.slkj.beans.Department;
import com.slkj.beans.Employee;
import com.slkj.beans.PageBean;

public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
