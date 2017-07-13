package dao;



import entity.Admin;
import entity.Employee;
import utils.PageBean;

public interface IEmployeeDao {

	/**
	 * ��ҳ��ѯ����
	 * @throws Exception 
	 */
	public void getAll(PageBean<Employee> pb) throws Exception;
	
	/**
	 * ��ѯ�ܼ�¼��
	 * @throws Exception 
	 */
	public int getTotalCount() throws Exception;
	Employee findByNameAndID(Employee employee) throws Exception;
	public boolean employeeExists(String name,int id) throws Exception;
	void save(Employee employee) throws Exception;
}
