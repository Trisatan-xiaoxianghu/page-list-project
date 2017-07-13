package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Exception.UserExistsException;
import entity.Employee;
import service.impl.EmployeeServiece;
import utils.WebUtils;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String uri;
	EmployeeServiece employeeService=new EmployeeServiece();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("进入了Registerservice");
		Employee empolyee = WebUtils.copyToBean(request, Employee.class);
		System.out.println(empolyee);
		try {
			employeeService.register(empolyee);
			System.out.println("已经成功保存");
		} catch (UserExistsException e) {
			// 用户名存在，注册失败(跳转到注册页面)
			request.setAttribute("message", "用户名已经存在");
			// 转发
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();  // 测试时候用
			// 其他错误, 跳转到错误页面
			response.sendRedirect(request.getContextPath() + "error.jsp");
		}
		
	
		request.getRequestDispatcher("index.jsp").forward(request, response);

	
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
