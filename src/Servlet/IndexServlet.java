package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.deploy.uitoolkit.impl.fx.Utils;

import entity.Employee;
import service.impl.EmployeeServiece;
import utils.PageBean;
import utils.WebUtils;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String uri;
	EmployeeServiece employeeService=new EmployeeServiece();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("进入了service");
		Employee empolyee = WebUtils.copyToBean(request, Employee.class);
		System.out.println(empolyee);
		System.out.println(empolyee.getEmpName());
		if(empolyee.getEmpName()==null)
		{

			try {
				//1. 获取“当前页”参数；  (第一次访问当前页为null) 
				String currPage = request.getParameter("currentPage");
				// 判断
				if (currPage == null || "".equals(currPage.trim())){
					currPage = "1";  	// 第一次访问，设置当前页为1;
				}
				// 转换
				int currentPage = Integer.parseInt(currPage);
				System.out.println(currentPage);
				//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
				PageBean<Employee> pageBean = new PageBean<Employee>();
				pageBean.setCurrentPage(currentPage);
				
			
				//3. 调用service  
				employeeService.getAll(pageBean);    // 【pageBean已经被dao填充了数据】
				
				//4. 保存pageBean对象，到request域中
				request.setAttribute("pageBean", pageBean);
				
				//5. 跳转 
				 uri = "list.jsp";
			} catch (Exception e) {
				e.printStackTrace();  // 测试使用
				// 出现错误，跳转到错误页面；给用户友好提示
				uri = "error.jsp";
			}
			request.getRequestDispatcher(uri).forward(request, response);
		}
			
			
			
		else {
			try {
				Employee employee2 = employeeService.login(empolyee);
				System.out.println(employee2);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				request.setAttribute("message", "用户名不在系统中");
				// 转发
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		
			try {
				//1. 获取“当前页”参数；  (第一次访问当前页为null) 
				String currPage = request.getParameter("currentPage");
				// 判断
				if (currPage == null || "".equals(currPage.trim())){
					currPage = "1";  	// 第一次访问，设置当前页为1;
				}
				// 转换
				int currentPage = Integer.parseInt(currPage);
				System.out.println(currentPage);
				//2. 创建PageBean对象，设置当前页参数； 传入service方法参数
				PageBean<Employee> pageBean = new PageBean<Employee>();
				pageBean.setCurrentPage(currentPage);
				
			
				//3. 调用service  
				employeeService.getAll(pageBean);    // 【pageBean已经被dao填充了数据】
				
				//4. 保存pageBean对象，到request域中
				request.setAttribute("pageBean", pageBean);
				
				//5. 跳转 
				 uri = "list.jsp";
			} catch (Exception e) {
				e.printStackTrace();  // 测试使用
				// 出现错误，跳转到错误页面；给用户友好提示
				uri = "error.jsp";
			}
			request.getRequestDispatcher(uri).forward(request, response);
			
		}
		
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
