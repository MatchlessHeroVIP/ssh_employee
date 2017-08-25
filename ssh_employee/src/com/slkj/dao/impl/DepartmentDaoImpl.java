package com.slkj.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.opensymphony.xwork2.ModelDriven;
import com.slkj.beans.Department;
import com.slkj.dao.DepartmentDao;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	/**
	 * 查询数据库总记录数
	 */
	public int findCount() {
		String hql= "select count(*) from Department";
	List<Long> list=	this.getHibernateTemplate().find(hql);
	if(list.size() > 0){
		 return list.get(0).intValue();
		
	}
		return 0;
	}

	/**
	 * 分页的方法
	 */
	public List<Department> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list=this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void saveDep(Department department) {
		
		this.getHibernateTemplate().save(department);
	}

	@Override
	public Department findById(Integer did) {
		
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	public void updateDep(Department department) {
		
	this.getHibernateTemplate().update(department);
	}

	@Override
	public void deleteDep(Department department) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(department);
	}

	@Override
	public List<Department> findAllDep() {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find("from Department");
	}

	
	
	
	

}
