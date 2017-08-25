package com.slkj.dao;

import java.util.List;

import com.slkj.beans.Department;


public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void saveDep(Department department);

	Department findById(Integer did);

	void updateDep(Department department);

	void deleteDep(Department department);

	List<Department> findAllDep();

	

}
