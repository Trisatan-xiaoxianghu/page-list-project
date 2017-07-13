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
		
			throw new UserNotInSystemException("�û���������ϵͳ�У����ܲ�ѯ��");
			}
		
		
		
	}

	@Override
	public void register(Employee employee) throws UserExistsException {
		// TODO Auto-generated method stub
		
		try {
			// 1. �ȸ����û�����ѯ�û��Ƿ����
			boolean flag = aemploydao.employeeExists(employee.getEmpName(), employee.getEmpId());
			System.out.println("���û��Ƿ����"+flag); 
			// 2. ����û����ڣ�������ע��
			if (flag){
				// ������ע��, ����������ʾ
				throw new UserExistsException("�û����Ѿ����ڣ�ע��ʧ�ܣ�");
			}
			
			// 3. �û������ڣ��ſ���ע��
			aemploydao.save(employee);
		
		} catch (UserExistsException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	
	}

}
