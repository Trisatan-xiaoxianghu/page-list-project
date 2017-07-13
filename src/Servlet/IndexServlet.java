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
		System.out.println("������service");
		Employee empolyee = WebUtils.copyToBean(request, Employee.class);
		System.out.println(empolyee);
		System.out.println(empolyee.getEmpName());
		if(empolyee.getEmpName()==null)
		{

			try {
				//1. ��ȡ����ǰҳ��������  (��һ�η��ʵ�ǰҳΪnull) 
				String currPage = request.getParameter("currentPage");
				// �ж�
				if (currPage == null || "".equals(currPage.trim())){
					currPage = "1";  	// ��һ�η��ʣ����õ�ǰҳΪ1;
				}
				// ת��
				int currentPage = Integer.parseInt(currPage);
				System.out.println(currentPage);
				//2. ����PageBean�������õ�ǰҳ������ ����service��������
				PageBean<Employee> pageBean = new PageBean<Employee>();
				pageBean.setCurrentPage(currentPage);
				
			
				//3. ����service  
				employeeService.getAll(pageBean);    // ��pageBean�Ѿ���dao��������ݡ�
				
				//4. ����pageBean���󣬵�request����
				request.setAttribute("pageBean", pageBean);
				
				//5. ��ת 
				 uri = "list.jsp";
			} catch (Exception e) {
				e.printStackTrace();  // ����ʹ��
				// ���ִ�����ת������ҳ�棻���û��Ѻ���ʾ
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
				request.setAttribute("message", "�û�������ϵͳ��");
				// ת��
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			
		
			try {
				//1. ��ȡ����ǰҳ��������  (��һ�η��ʵ�ǰҳΪnull) 
				String currPage = request.getParameter("currentPage");
				// �ж�
				if (currPage == null || "".equals(currPage.trim())){
					currPage = "1";  	// ��һ�η��ʣ����õ�ǰҳΪ1;
				}
				// ת��
				int currentPage = Integer.parseInt(currPage);
				System.out.println(currentPage);
				//2. ����PageBean�������õ�ǰҳ������ ����service��������
				PageBean<Employee> pageBean = new PageBean<Employee>();
				pageBean.setCurrentPage(currentPage);
				
			
				//3. ����service  
				employeeService.getAll(pageBean);    // ��pageBean�Ѿ���dao��������ݡ�
				
				//4. ����pageBean���󣬵�request����
				request.setAttribute("pageBean", pageBean);
				
				//5. ��ת 
				 uri = "list.jsp";
			} catch (Exception e) {
				e.printStackTrace();  // ����ʹ��
				// ���ִ�����ת������ҳ�棻���û��Ѻ���ʾ
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
