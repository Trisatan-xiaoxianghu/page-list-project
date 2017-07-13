package service.impl;


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
		
			throw new UserNotInSystemException("�û���������ϵͳ�У����ܲ�ѯ��");
			}
		
		
		
	}

}
