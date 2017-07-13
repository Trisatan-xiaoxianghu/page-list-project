package dao;



import entity.Admin;
import entity.Employee;
import utils.PageBean;

public interface IEmployeeDao {

	/**
	 * 分页查询数据
	 * @throws Exception 
	 */
	public void getAll(PageBean<Employee> pb) throws Exception;
	
	/**
	 * 查询总记录数
	 * @throws Exception 
	 */
	public int getTotalCount() throws Exception;
	Employee findByNameAndID(Employee employee) throws Exception;
	public boolean employeeExists(String name,int id) throws Exception;
	void save(Employee employee) throws Exception;
}
