package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import appConstant.ViewPages;
import model.Customer;
import service.CustomerDao;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/Profile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDao dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao=new CustomerDao();
	}
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher(ViewPages.USER_PROFILE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}
//		HttpSession session=request.getSession(false);
//		int customer_id=(Integer)(session.getAttribute("customer_id"));
//		Customer customer=new Customer();
//		customer.setFirst_name(request.getParameter("first_name"));
//		customer.setLast_name(request.getParameter("last_name"));
//		customer.setUsername(request.getParameter("username"));
//		customer.setAddress(request.getParameter("address"));
//		customer.setEmail(request.getParameter("email"));
//		customer.setPhone_number(request.getParameter("phone_number"));
//		
//		customer.setCustomer_id(customer_id);
//		try {
//			int row=dao.updateCustomer(customer);
//			if(row>0)
//			{
//				response.sendRedirect(request.getContextPath()+"/Home");
//			}
//			else
//			{
//				request.getRequestDispatcher(ViewPages.USER_PROFILE).forward(request, response);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//	
//	}

}
