package com.slkj.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.slkj.beans.Department;
import com.slkj.beans.Employee;
import com.slkj.dao.EmployeeDao;

	public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {
	
		@Override
		public Employee findUernameAndPassword(Employee employee) {
			String queryString ="from Employee where username = ? and password = ?";
		List<Employee> list =this.getHibernateTemplate().find(queryString , employee.getUsername(),employee.getPassword());
			if(list.size()>0){
				return list.get(0);
			}
			return null;
		}

	/**
	 * 查询数据库总记录数
	 */
	public int findCount() {
		String hql= "select count(*) from Employee";
		List<Long> list=	this.getHibernateTemplate().find(hql);
		if(list.size() > 0){
			 return list.get(0).intValue();
			
		}
			return 0;
	}

	/**
	 * 分页
	 * 
	 */
	public List<Employee> findByPage(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list=this.getHibernateTemplate().findByCriteria(criteria, begin, pageSize);
		return list;
	}

	@Override
	public void saveEmp(Employee employee) {
		this.getHibernateTemplate().save(employee);
		
	}

	@Override
	public Employee findById(Integer eid) {
		
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void updateEmp(Employee employee) {
		this.getHibernateTemplate().update(employee);
		
	}

	@Override
	public void deleteEmp(Employee employee) {
	this.getHibernateTemplate().delete(employee);
		
	}
	
	

}
