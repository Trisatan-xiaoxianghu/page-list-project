package service;



import entity.Employee;
import utils.PageBean;

public interface IEmployeeService {
	public void getAll(PageBean<Employee> pb);
	Employee login(Employee employee) throws Exception;
}
