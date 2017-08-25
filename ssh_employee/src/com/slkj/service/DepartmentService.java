package com.slkj.service;

import java.util.List;

import com.slkj.beans.Department;
import com.slkj.beans.PageBean;

public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAllDep();

}
