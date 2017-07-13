package service.impl;


import Exception.UserExistsException;
import Exception.UserNotInSystemException;
import entity.Employee;


import impl.EmployeeDao2;
import service.IEmployeeService;
import utils.PageBean;

public class EmployeeServiece implements IEmployeeService {
	EmployeeDao2 aemploydao= new EmployeeDao2();
	public EmployeeServiece() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getAll(PageBean<Employee> pb)
	{
		try {
			aemploydao.getAll(pb);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Employee login(Employee employee) throws Exception  {
		// TODO Auto-generated method stub
		boolean flag = aemploydao.employeeExists(employee.getEmpName(),employee.getEmpId());
		if(flag){
			return aemploydao.findByNameAndID(employee);
		}
		else{
		
			throw new UserNotInSystemException("用户名不存在系统中，不能查询！");
			}
		
		
		
	}

	@Override
	public void register(Employee employee) throws UserExistsException {
		// TODO Auto-generated method stub
		
		try {
			// 1. 先根据用户名查询用户是否存在
			boolean flag = aemploydao.employeeExists(employee.getEmpName(), employee.getEmpId());
			System.out.println("该用户是否存在"+flag); 
			// 2. 如果用户存在，不允许注册
			if (flag){
				// 不允许注册, 给调用者提示
				throw new UserExistsException("用户名已经存在，注册失败！");
			}
			
			// 3. 用户不存在，才可以注册
			aemploydao.save(employee);
		
		} catch (UserExistsException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
	}

}
