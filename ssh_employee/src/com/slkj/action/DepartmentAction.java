package com.slkj.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.slkj.beans.Department;
import com.slkj.beans.Employee;
import com.slkj.beans.PageBean;
import com.slkj.service.DepartmentService;

public class DepartmentAction extends ActionSupport implements  ModelDriven<Department> {

	private Department department = new Department() ; 
	@Override
	public Department getModel() {
		// TODO Auto-generated method stub
		return department;
	}
	//注入部门管理的Service
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	private Integer currPage =1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	//分页查询所有
	public String findAll(){
	PageBean<Department> pageBean=	departmentService.findByPage(currPage);
		//将PageBean放入到值栈中
	ActionContext.getContext().getValueStack().push(pageBean);;
		return "findAll";
	}
	//跳转到添加页面
	public String saveUI(){
		
		return "saveUI";
	}
	//添加部门
	public String save(){
		departmentService.save(department);
		
		return "saveSuccess";
	}
	//编辑部门
	public String edit(){
		department =departmentService.findById(department.getDid());
		
		return "editSuccess";
	}
	//修改部门
	public String update(){
		departmentService.update(department);
		return "updateSuccess";
	}
	
	//删除部门
	
	public String delete(){
		
	department=	departmentService.findById(department.getDid());
		departmentService.delete(department);
		
		return "deleteSuccess";
		
	}
	
}
