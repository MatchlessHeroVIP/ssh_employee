package com.slkj.dao;

import java.util.List;

import com.slkj.beans.Department;
import com.slkj.beans.Employee;

public interface EmployeeDao {

	Employee findUernameAndPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int begin, int pageSize);

	void saveEmp(Employee employee);

	Employee findById(Integer eid);

	void updateEmp(Employee employee);

	void deleteEmp(Employee employee);

}
