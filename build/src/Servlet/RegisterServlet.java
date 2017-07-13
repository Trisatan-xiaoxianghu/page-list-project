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
		System.out.println("������Registerservice");
		Employee empolyee = WebUtils.copyToBean(request, Employee.class);
		System.out.println(empolyee);
		try {
			employeeService.register(empolyee);
			System.out.println("�Ѿ��ɹ�����");
		} catch (UserExistsException e) {
			// �û������ڣ�ע��ʧ��(��ת��ע��ҳ��)
			request.setAttribute("message", "�û����Ѿ�����");
			// ת��
			request.getRequestDispatcher("/register.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();  // ����ʱ����
			// ��������, ��ת������ҳ��
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
