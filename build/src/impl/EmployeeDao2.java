package impl;

import java.sql.SQLException;





import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.eclipse.jdt.internal.compiler.lookup.ClassScope;
import org.junit.Test;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import com.sun.corba.se.pept.transport.EventHandler;

import dao.IEmployeeDao;

import entity.Employee;

import utils.JdbcUtils;
import utils.PageBean;


public class EmployeeDao2 implements IEmployeeDao {

	public EmployeeDao2() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void getAll(PageBean<Employee> pb) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("utils.JdbcUtils");
		pb.setTotalCount(this.getTotalCount());
		pb.setTotalPage(pb.getTotalPage());
		
		if (pb.getCurrentPage() <=0) {
			pb.setCurrentPage(1);					    // 把当前页设置为1
		} else if (pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());		// 把当前页设置为最大页数
		}
	
		int index2=(pb.getCurrentPage())-1;
	
		int index3=index2*pb.getPageCount();
		
		String sql = "select * from employee limit ?,?";
	
		Object[] paramsValue={index3,pb.getPageCount()};
		List<Employee> list=JdbcUtils.qr.query( sql, new BeanListHandler<Employee>(Employee.class),paramsValue);
		System.out.println(list);
	    pb.setPageData(list);
		
		
	}
	/**
	 * 查询总记录数
	 * @throws Exception 
	 * @throws Exception 
	 */
	@Override
	public int getTotalCount() throws Exception   {
		// TODO Auto-generated method stub
		Class.forName("utils.JdbcUtils");
		String sql = "SELECT * FROM day22.employee; ";

		List<Employee> list=JdbcUtils.qr.query( sql, new BeanListHandler<Employee>(Employee.class));
		
		return list.size();
	
	}

	@Override
	public Employee findByNameAndID(Employee employee) throws Exception {
		// TODO Auto-generated method stub
	
		Class.forName("utils.JdbcUtils");
		
		String sql = "SELECT * FROM day22.employee where empName=?;";
		Object[] paramsValue={employee.getEmpName()};
		Employee employee2=JdbcUtils.qr.query( sql, new BeanHandler<Employee>(Employee.class),paramsValue);
	
		return employee2;
		
		
		
	}
	@Override
	public boolean employeeExists(String name,int id) throws Exception {
		// TODO Auto-generated method stub
			Class.forName("utils.JdbcUtils");
			String sql = "SELECT * FROM day22.employee where empName=? and empId=?;";
			Object[] paramsValue={name,id};
			Employee employee2=JdbcUtils.qr.query( sql, new BeanHandler<Employee>(Employee.class),paramsValue);
			return employee2!=null;
				
	}

	@Override
	public void save(Employee employee) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("utils.JdbcUtils");
		String sql = "insert day22.employee values(?,?,?);";
		Object[] paramsValue={employee.getEmpId(),employee.getEmpName(),employee.getEmpId()};
		JdbcUtils.qr.update(sql, paramsValue);
	}

	
}
