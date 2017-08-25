package com.slkj.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.slkj.beans.Department;
import com.slkj.beans.PageBean;
import com.slkj.dao.DepartmentDao;
import com.slkj.service.DepartmentService;
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	
	public PageBean<Department> findByPage(Integer currPage) {
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		
		//封装每页显示多少条
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		
		//封装总记录数，数据库总条数
		int totalCount = departmentDao.findCount();
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
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		
		
		return pageBean;
	}


	@Override
	public void save(Department department) {
		departmentDao.saveDep(department);
		
	}


	@Override
	public Department findById(Integer did) {
		
		return departmentDao.findById(did);
	}


	@Override
	public void update(Department department) {
		departmentDao.updateDep(department);
		
	}


	@Override
	public void delete(Department department) {
		
		departmentDao.deleteDep(department);
	}


	@Override
	public List<Department> findAllDep() {
	
		return departmentDao.findAllDep();
	}






	
	

}
