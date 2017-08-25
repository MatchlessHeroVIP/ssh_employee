package com.slkj.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.slkj.beans.Department;
import com.slkj.beans.Employee;
import com.slkj.beans.PageBean;
import com.slkj.service.DepartmentService;
import com.slkj.service.EmployeeService;

public class EmployeeAction extends ActionSupport implements
		ModelDriven<Employee> {
	// 模型驱动需要使用的类
	private Employee employee = new Employee();

	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}

	// 注入Employee业务层的类
	private EmployeeService employeeService;

	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	// 注入Department业务层的类
	private DepartmentService departmentService;

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public String login() {

		Employee exsitEm = employeeService.login(employee);
		if (exsitEm == null) {
			this.addActionError("用户名或密码错误");
			return INPUT;
		} else {
			ActionContext.getContext().getSession().put("exsitEm", exsitEm);
			return SUCCESS;
		}

	}

	private Integer currPage = 1;

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	// 分页查询所有
	public String findAll() {
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		// 将PageBean放入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		;
		return "findAll";
	}

	// 跳转到添加员工界面
	public String saveUI() {
		// 查询所有部门信息
		List<Department> list = departmentService.findAllDep();

		ActionContext.getContext().getValueStack().set("list", list);// 集合用set
																		// 对象用push
		return "saveUI";
	}

	// 添加员工
	public String save() {

		employeeService.save(employee);

		return "saveSuccess";
	}

	// 编辑员工
	public String edit() {
		employee = employeeService.findById(employee.getEid());
		List<Department> list = departmentService.findAllDep();
		ActionContext.getContext().getValueStack().set("list", list);// 集合用set
																		// 对象用push
		return "editSuccess";
	}
	
	//修改员工
		public String update(){
			employeeService.update(employee);
			return "updateSuccess";
		}
		
		//删除员工
		
		public String delete(){
			employee=employeeService.findById(employee.getEid());
			employeeService.delete(employee);
			
			return "deleteSuccess";
		}

}
